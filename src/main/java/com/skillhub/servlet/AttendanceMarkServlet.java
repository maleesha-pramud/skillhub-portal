package com.skillhub.servlet;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: Mark Attendance (Admin only; enforced by AuthorizationFilter). */
public class AttendanceMarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        List<Course> courses = store.findCourses();
        Course selected = store.findCourse(WebUtil.toInt(req.getParameter("courseId"), 0));
        if (selected == null && !courses.isEmpty()) selected = courses.get(0);
        LocalDate date = parseDate(req.getParameter("date"));

        List<User> students = new ArrayList<>();
        Map<Integer, String> existing = new HashMap<>();
        if (selected != null) {
            for (Enrolment e : store.enrolmentsByCourse(selected.getId())) {
                User s = store.findUser(e.getStudentId());
                if (s != null && "ACTIVE".equals(e.getStatus())) students.add(s);
            }
            for (Attendance a : store.attendanceByCourse(selected.getId())) {
                if (a.getDate().equals(date)) existing.put(a.getStudentId(), a.getStatus());
            }
        }
        req.setAttribute("courses", courses);
        req.setAttribute("selectedCourse", selected);
        req.setAttribute("students", students);
        req.setAttribute("existing", existing);
        req.setAttribute("sessionDate", date.toString());
        req.setAttribute("today", LocalDate.now().toString());
        WebUtil.render(req, res, "attendance-mark");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        Course course = store.findCourse(WebUtil.toInt(req.getParameter("courseId"), 0));
        LocalDate date = parseDate(req.getParameter("date"));
        if (course == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<Integer, String> statuses = new LinkedHashMap<>();
        for (Enrolment e : store.enrolmentsByCourse(course.getId())) {
            if (!"ACTIVE".equals(e.getStatus())) continue;
            String s = WebUtil.trim(req.getParameter("status_" + e.getStudentId()));
            if (Attendance.PRESENT.equals(s) || Attendance.LATE.equals(s) || Attendance.ABSENT.equals(s)) {
                statuses.put(e.getStudentId(), s);
            }
        }
        if (statuses.isEmpty()) {
            Flash.error(req, "There are no enrolled students to mark for this course.");
            WebUtil.redirect(req, res, "/attendance/mark?courseId=" + course.getId());
            return;
        }
        store.markAttendance(course.getId(), date, statuses);
        store.log(user.getFullName() + " marked attendance for " + course.getCode() + " on " + date);
        Flash.success(req, "Attendance saved for " + course.getCode() + " on " + date + ".");
        WebUtil.redirect(req, res, "/attendance?courseId=" + course.getId());
    }

    /** Parses yyyy-MM-dd; invalid or future dates fall back to today. */
    private LocalDate parseDate(String s) {
        try {
            LocalDate d = LocalDate.parse(WebUtil.trim(s));
            return d.isAfter(LocalDate.now()) ? LocalDate.now() : d;
        } catch (DateTimeParseException e) {
            return LocalDate.now();
        }
    }
}
