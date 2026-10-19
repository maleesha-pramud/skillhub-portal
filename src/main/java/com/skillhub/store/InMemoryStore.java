package com.skillhub.store;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.util.PasswordUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Application data held entirely in memory (no database), as required by the assessment.
 * One instance is created by AppContextListener and stored in the ServletContext (application scope).
 * All collections are thread-safe because many request threads share this object.
 */
public class InMemoryStore {
    private static final int LOCK_MAX_FAILURES = 5;
    private static final long LOCK_WINDOW_MS = 5 * 60 * 1000L;
    private static final DateTimeFormatter LOG_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final Map<Integer, Course> courses = new ConcurrentHashMap<>();
    private final Map<Integer, Enrolment> enrolments = new ConcurrentHashMap<>();
    private final Map<Integer, Attendance> attendance = new ConcurrentHashMap<>();
    private final AtomicInteger userSeq = new AtomicInteger();
    private final AtomicInteger courseSeq = new AtomicInteger();
    private final AtomicInteger enrolSeq = new AtomicInteger();
    private final AtomicInteger attSeq = new AtomicInteger();
    private final Deque<String> activityLog = new ConcurrentLinkedDeque<>();
    private final Map<String, long[]> failedLogins = new ConcurrentHashMap<>();
    private final String dummyHash = PasswordUtil.hash("not-a-real-password");

    // ---------------------------------------------------------------- users

    public List<User> findUsers(Role role) {
        return users.values().stream()
                .filter(u -> role == null || u.getRole() == role)
                .sorted(Comparator.comparingInt(User::getId))
                .collect(Collectors.toList());
    }

    public User findUser(int id) {
        return users.get(id);
    }

    public User findByUsername(String username) {
        if (username == null) return null;
        for (User u : users.values()) {
            if (u.getUsername().equalsIgnoreCase(username.trim())) return u;
        }
        return null;
    }

    public boolean usernameTaken(String username, int exceptId) {
        User u = findByUsername(username);
        return u != null && u.getId() != exceptId;
    }

    public synchronized User saveUser(User u) {
        if (u.getId() == 0) {
            u.setId(userSeq.incrementAndGet());
        }
        users.put(u.getId(), u);
        return u;
    }

    public synchronized void deleteUser(int id) {
        users.remove(id);
        enrolments.values().removeIf(e -> e.getStudentId() == id);
        attendance.values().removeIf(a -> a.getStudentId() == id);
    }

    /** Returns the user when the credentials are valid and the account is active, otherwise null. */
    public User authenticate(String username, String password) {
        User u = findByUsername(username);
        if (u == null) {
            PasswordUtil.verify(password, dummyHash); // keep timing similar for unknown users
            return null;
        }
        if (!u.isActive()) {
            return null;
        }
        return PasswordUtil.verify(password, u.getPasswordHash()) ? u : null;
    }

    public boolean isLocked(String username) {
        String key = username.toLowerCase();
        long[] rec = failedLogins.get(key);
        if (rec == null) return false;
        if (System.currentTimeMillis() - rec[1] > LOCK_WINDOW_MS) {
            failedLogins.remove(key);
            return false;
        }
        return rec[0] >= LOCK_MAX_FAILURES;
    }

    public synchronized void recordFailure(String username) {
        String key = username.toLowerCase();
        long[] rec = failedLogins.get(key);
        if (rec == null || System.currentTimeMillis() - rec[1] > LOCK_WINDOW_MS) {
            failedLogins.put(key, new long[] {1, System.currentTimeMillis()});
        } else {
            rec[0]++;
        }
    }

    public void clearFailures(String username) {
        failedLogins.remove(username.toLowerCase());
    }

    // -------------------------------------------------------------- courses

    public List<Course> findCourses() {
        return courses.values().stream()
                .sorted(Comparator.comparingInt(Course::getId))
                .collect(Collectors.toList());
    }

    public Course findCourse(int id) {
        return courses.get(id);
    }

    public List<Course> coursesByTrainer(int trainerId) {
        return findCourses().stream().filter(c -> c.getTrainerId() == trainerId).collect(Collectors.toList());
    }

    public boolean courseCodeTaken(String code, int exceptId) {
        return courses.values().stream()
                .anyMatch(c -> c.getCode().equalsIgnoreCase(code) && c.getId() != exceptId);
    }

    public synchronized Course saveCourse(Course c) {
        if (c.getId() == 0) {
            c.setId(courseSeq.incrementAndGet());
        }
        courses.put(c.getId(), c);
        return c;
    }

    public int enrolledCount(int courseId) {
        return (int) enrolments.values().stream()
                .filter(e -> e.getCourseId() == courseId && "ACTIVE".equals(e.getStatus()))
                .count();
    }

    // ----------------------------------------------------------- enrolments

    /** Newest first. */
    public List<Enrolment> findEnrolments() {
        return enrolments.values().stream()
                .sorted(Comparator.comparingInt(Enrolment::getId).reversed())
                .collect(Collectors.toList());
    }

    public List<Enrolment> enrolmentsByStudent(int studentId) {
        return findEnrolments().stream().filter(e -> e.getStudentId() == studentId).collect(Collectors.toList());
    }

    public List<Enrolment> enrolmentsByCourse(int courseId) {
        return findEnrolments().stream().filter(e -> e.getCourseId() == courseId).collect(Collectors.toList());
    }

    public boolean isEnrolled(int studentId, int courseId) {
        return enrolments.values().stream().anyMatch(e -> e.getStudentId() == studentId
                && e.getCourseId() == courseId && "ACTIVE".equals(e.getStatus()));
    }

    /** Enrols a student. Returns an error message, or null on success. */
    public synchronized String enrol(int studentId, int courseId) {
        User s = findUser(studentId);
        Course c = findCourse(courseId);
        if (s == null || s.getRole() != Role.STUDENT) return "The selected student was not found.";
        if (c == null || !c.isActive()) return "The selected course is not available.";
        if (isEnrolled(studentId, courseId)) return s.getFullName() + " is already enrolled in " + c.getCode() + ".";
        if (enrolledCount(courseId) >= c.getCapacity()) return c.getCode() + " is full. No seats are available.";
        Enrolment e = new Enrolment();
        e.setId(enrolSeq.incrementAndGet());
        e.setStudentId(studentId);
        e.setCourseId(courseId);
        e.setEnrolledOn(LocalDate.now());
        enrolments.put(e.getId(), e);
        log(s.getFullName() + " enrolled in " + c.getCode());
        return null;
    }

    // ----------------------------------------------------------- attendance

    public List<Attendance> findAttendance() {
        return sortAttendance(attendance.values());
    }

    public List<Attendance> attendanceByCourse(int courseId) {
        return sortAttendance(attendance.values().stream()
                .filter(a -> a.getCourseId() == courseId).collect(Collectors.toList()));
    }

    public List<Attendance> attendanceByStudent(int studentId) {
        return sortAttendance(attendance.values().stream()
                .filter(a -> a.getStudentId() == studentId).collect(Collectors.toList()));
    }

    /** Saves (or replaces) attendance for each student for the given course and date. */
    public synchronized void markAttendance(int courseId, LocalDate date, Map<Integer, String> statuses) {
        for (Map.Entry<Integer, String> en : statuses.entrySet()) {
            attendance.values().removeIf(a -> a.getCourseId() == courseId
                    && a.getStudentId() == en.getKey() && a.getDate().equals(date));
            Attendance a = new Attendance();
            a.setId(attSeq.incrementAndGet());
            a.setCourseId(courseId);
            a.setStudentId(en.getKey());
            a.setDate(date);
            a.setStatus(en.getValue());
            attendance.put(a.getId(), a);
        }
    }

    /** Percentage of sessions attended (PRESENT or LATE). */
    public static int attendanceRate(Collection<Attendance> records) {
        if (records.isEmpty()) return 0;
        long attended = records.stream().filter(a -> !Attendance.ABSENT.equals(a.getStatus())).count();
        return (int) Math.round(attended * 100.0 / records.size());
    }

    private static List<Attendance> sortAttendance(Collection<Attendance> src) {
        List<Attendance> list = new ArrayList<>(src);
        list.sort(Comparator.comparing(Attendance::getDate).thenComparingInt(Attendance::getId).reversed());
        return list;
    }

    // ---------------------------------------------------------- activity log

    public void log(String message) {
        String clean = message == null ? "" : message.replaceAll("[\\r\\n\\t]", " ");
        activityLog.addFirst(LocalDateTime.now().format(LOG_TIME) + "  " + clean);
        while (activityLog.size() > 100) {
            activityLog.pollLast();
        }
    }

    public List<String> recentLog(int max) {
        return activityLog.stream().limit(max).collect(Collectors.toList());
    }

    // ------------------------------------------------------------- seed data

    /** Loads the demo data: one admin, three trainers, six students and eight Sri Lankan courses. */
    public void seed() {
        User admin = newUser("nuwan", "Nuwan@2026", "Nuwan Perera", "nuwan.perera@skillhub.lk", "+94771234501", Role.ADMIN);
        User dilani = newUser("dilani", "Dilani@2026", "Dilani Fernando", "dilani.fernando@skillhub.lk", "+94771234502", Role.TRAINER);
        User sanjeewa = newUser("sanjeewa", "Sanjeewa@2026", "Sanjeewa Jayasinghe", "sanjeewa.j@skillhub.lk", "+94712345603", Role.TRAINER);
        User thilini = newUser("thilini", "Thilini@2026", "Thilini Wickramasinghe", "thilini.w@skillhub.lk", "+94762345604", Role.TRAINER);

        User[] students = {
                newUser("kasun", "Kasun@2026", "Kasun Rajapaksha", "kasun.rajapaksha@example.lk", "+94773456701", Role.STUDENT),
                newUser("sathya", "Sathya@2026", "Sathyaa Kandasamy", "sathyaa.k@example.lk", "+94773456702", Role.STUDENT),
                newUser("ishara", "Ishara@2026", "Ishara Gunawardena", "ishara.g@example.lk", "+94713456703", Role.STUDENT),
                newUser("farhan", "Farhan@2026", "Mohamed Farhan", "farhan.m@example.lk", "+94753456704", Role.STUDENT),
                newUser("hirushi", "Hirushi@2026", "Hirushi Senanayake", "hirushi.s@example.lk", "+94703456705", Role.STUDENT),
                newUser("tharindu", "Tharindu@2026", "Tharindu Bandara", "tharindu.b@example.lk", "+94783456706", Role.STUDENT)
        };

        Course[] courses = {
                newCourse("JEE101", "Java EE Web Development", "Technology",
                        "Servlets, JSP, sessions, filters, listeners and WAR deployment on Apache Tomcat, with a capstone for a Colombo-based retailer.",
                        dilani.getId(), 12, 25, 85000, "Mon & Wed, 6:00 - 8:00 PM (Colombo 03)"),
                newCourse("WEB201", "Modern Frontend Development", "Technology",
                        "Responsive interfaces with HTML5, CSS3, JavaScript and Bootstrap, including Sinhala and Tamil Unicode content.",
                        dilani.getId(), 10, 30, 65000, "Tue & Thu, 6:00 - 8:00 PM (Colombo 03)"),
                newCourse("DATA210", "Data Analytics with Python", "Technology",
                        "Clean, analyse and visualise real Sri Lankan datasets: tea exports, tourism arrivals and census statistics.",
                        sanjeewa.getId(), 10, 25, 72000, "Sat, 9:00 AM - 1:00 PM (Kandy)"),
                newCourse("BUS110", "Project Management Essentials", "Business",
                        "Planning, scheduling, risk and stakeholder management for new project leaders in Sri Lankan organisations.",
                        sanjeewa.getId(), 8, 20, 48000, "Saturday, 2:00 - 6:00 PM (Colombo 07)"),
                newCourse("ENT120", "Starting a Small Business in Sri Lanka", "Business",
                        "Business registration, IRD tax basics, costing, pricing and marketing for new entrepreneurs and home-based sellers.",
                        sanjeewa.getId(), 6, 35, 25000, "Sunday, 9:00 AM - 12:00 PM (Galle)"),
                newCourse("ENG140", "Spoken English for Professionals", "Professional Development",
                        "Confident everyday and workplace English: meetings, phone calls, interviews and presentations.",
                        thilini.getId(), 8, 40, 18000, "Tue & Fri, 5:30 - 7:00 PM (Colombo 05)"),
                newCourse("PRO150", "Professional Communication Skills", "Professional Development",
                        "Business writing, presentations and workplace communication for Sri Lanka's growing services sector.",
                        thilini.getId(), 6, 40, 30000, "Sunday, 10:00 AM - 12:00 PM"),
                newCourse("LAN160", "Sinhala & Tamil Conversation for the Workplace", "Languages",
                        "Practical Sinhala and Tamil for customer service, healthcare and public-facing roles, to serve every community.",
                        thilini.getId(), 8, 30, 20000, "Wed, 6:00 - 8:00 PM (Jaffna / online)")
        };

        // {student index, course index, days since enrolment}
        int[][] enrolments = {
                {0, 0, 30}, {0, 1, 21}, {0, 5, 12},
                {1, 0, 28}, {1, 2, 24}, {1, 7, 10},
                {2, 1, 26}, {2, 3, 20}, {2, 5, 9},
                {3, 2, 22}, {3, 4, 15}, {3, 6, 8},
                {4, 3, 18}, {4, 5, 14}, {4, 7, 6},
                {5, 0, 27}, {5, 4, 13}, {5, 6, 7}
        };
        for (int[] e : enrolments) {
            enrolDirect(students[e[0]].getId(), courses[e[1]].getId(), LocalDate.now().minusDays(e[2]));
        }

        // Five recorded sessions for the four longest-running courses.
        String pattern = "PPPLPPAPPLPPPAP";
        for (int c = 0; c < 4; c++) {
            for (int i = 0; i < 5; i++) {
                Map<Integer, String> marks = new ConcurrentHashMap<>();
                for (int[] e : enrolments) {
                    if (e[1] != c) {
                        continue;
                    }
                    char ch = pattern.charAt((e[0] * 3 + i * 2 + c) % pattern.length());
                    marks.put(students[e[0]].getId(),
                            ch == 'P' ? Attendance.PRESENT : ch == 'L' ? Attendance.LATE : Attendance.ABSENT);
                }
                markAttendance(courses[c].getId(), LocalDate.now().minusDays((5 - i) * 3L - (c % 2)), marks);
            }
        }
        log("System started. Demo data loaded for " + admin.getFullName() + ", " + dilani.getFullName()
                + ", " + sanjeewa.getFullName() + ", " + thilini.getFullName()
                + " and " + students.length + " students.");
    }

    private User newUser(String username, String password, String name, String email, String phone, Role role) {
        User u = new User();
        u.setUsername(username);
        u.setPasswordHash(PasswordUtil.hash(password));
        u.setFullName(name);
        u.setEmail(email);
        u.setPhone(phone);
        u.setRole(role);
        u.setCreatedAt(LocalDate.now().minusDays(60));
        return saveUser(u);
    }

    private Course newCourse(String code, String title, String cat, String desc, int trainerId,
                             int weeks, int cap, double fee, String schedule) {
        Course c = new Course();
        c.setCode(code);
        c.setTitle(title);
        c.setCategory(cat);
        c.setDescription(desc);
        c.setTrainerId(trainerId);
        c.setDurationWeeks(weeks);
        c.setCapacity(cap);
        c.setFee(fee);
        c.setSchedule(schedule);
        return saveCourse(c);
    }

    private void enrolDirect(int studentId, int courseId, LocalDate on) {
        Enrolment e = new Enrolment();
        e.setId(enrolSeq.incrementAndGet());
        e.setStudentId(studentId);
        e.setCourseId(courseId);
        e.setEnrolledOn(on);
        enrolments.put(e.getId(), e);
    }
}
