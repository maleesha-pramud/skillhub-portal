package com.skillhub.servlet;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Builds the role-specific dashboard (cards, tables and summaries). */
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);

        if (user.isAdmin()) {
            adminData(req, store);
        } else if (user.isTrainer()) {
            trainerData(req, store, user);
        } else {
            studentData(req, store, user);
        }
        WebUtil.render(req, res, "dashboard");
    }

    private void adminData(HttpServletRequest req, InMemoryStore store) {
        List<Course> courses = store.findCourses();
        List<Enrolment> enrolments = store.findEnrolments();

        req.setAttribute("totalStudents", store.findUsers(Role.STUDENT).size());
        req.setAttribute("totalTrainers", store.findUsers(Role.TRAINER).size());
        req.setAttribute("totalCourses", courses.size());
        req.setAttribute("totalEnrolments", enrolments.size());
        req.setAttribute("attendanceRate", InMemoryStore.attendanceRate(store.findAttendance()));
        req.setAttribute("activeSessions", ((AtomicInteger) req.getServletContext().getAttribute("activeSessions")).get());
        req.setAttribute("totalRequests", ((AtomicLong) req.getServletContext().getAttribute("totalRequests")).get());
        req.setAttribute("recentEnrolments", enrolments.subList(0, Math.min(5, enrolments.size())));

        List<Map<String, Object>> util = new ArrayList<>();
        Map<String, Integer> categories = new LinkedHashMap<>();
        for (Course c : courses) {
            int enrolled = store.enrolledCount(c.getId());
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("code", c.getCode());
            row.put("title", c.getTitle());
            row.put("enrolled", enrolled);
            row.put("capacity", c.getCapacity());
            row.put("pct", c.getCapacity() == 0 ? 0 : Math.min(100, enrolled * 100 / c.getCapacity()));
            util.add(row);
            categories.merge(c.getCategory(), 1, Integer::sum);
        }
        req.setAttribute("courseUtil", util);
        req.setAttribute("categoryCounts", categories);
    }

    private void trainerData(HttpServletRequest req, InMemoryStore store, User user) {
        List<Course> mine = store.coursesByTrainer(user.getId());
        Set<Integer> students = new HashSet<>();
        List<Attendance> records = new ArrayList<>();
        for (Course c : mine) {
            for (Enrolment e : store.enrolmentsByCourse(c.getId())) {
                students.add(e.getStudentId());
            }
            records.addAll(store.attendanceByCourse(c.getId()));
        }
        records.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        Set<String> sessions = new HashSet<>();
        for (Attendance a : records) {
            sessions.add(a.getCourseId() + "|" + a.getDate());
        }
        req.setAttribute("myCourses", mine);
        req.setAttribute("studentCount", students.size());
        req.setAttribute("sessionCount", sessions.size());
        req.setAttribute("attendanceRate", InMemoryStore.attendanceRate(records));
        req.setAttribute("recentAttendance", records.subList(0, Math.min(6, records.size())));
    }

    private void studentData(HttpServletRequest req, InMemoryStore store, User user) {
        List<Enrolment> mine = store.enrolmentsByStudent(user.getId());
        List<Attendance> records = store.attendanceByStudent(user.getId());
        int available = 0;
        for (Course c : store.findCourses()) {
            if (c.isActive() && !store.isEnrolled(user.getId(), c.getId())) available++;
        }
        req.setAttribute("myEnrolments", mine);
        req.setAttribute("attendanceRate", InMemoryStore.attendanceRate(records));
        req.setAttribute("sessionCount", records.size());
        req.setAttribute("availableCourses", available);
        req.setAttribute("recentAttendance", records.subList(0, Math.min(5, records.size())));
    }
}
