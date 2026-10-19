package com.skillhub.servlet;

import com.skillhub.model.Attendance;
import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Use cases: View Attendance (Student: own records, Trainer: records of assigned courses)
 * and View Attendance Report (Admin: all courses).
 */
public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);

        // 1. Which courses may this user look at?
        List<Course> selectable = new ArrayList<>();
        if (user.isAdmin()) {
            selectable = store.findCourses();
        } else if (user.isTrainer()) {
            selectable = store.coursesByTrainer(user.getId());
        } else {
            for (Enrolment e : store.enrolmentsByStudent(user.getId())) {
                Course c = store.findCourse(e.getCourseId());
                if (c != null) selectable.add(c);
            }
        }

        // 2. Optional course filter (must be one of the selectable courses)
        Course selected = null;
        int courseId = WebUtil.toInt(req.getParameter("courseId"), 0);
        if (courseId != 0) {
            for (Course c : selectable) {
                if (c.getId() == courseId) selected = c;
            }
            if (selected == null) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }

        // 3. Collect the records
        List<Attendance> records = new ArrayList<>();
        if (user.isStudent()) {
            for (Attendance a : store.attendanceByStudent(user.getId())) {
                if (selected == null || a.getCourseId() == selected.getId()) records.add(a);
            }
        } else if (selected != null) {
            records.addAll(store.attendanceByCourse(selected.getId()));
        } else {
            for (Course c : selectable) {
                records.addAll(store.attendanceByCourse(c.getId()));
            }
            records.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        }

        // 4. Summary numbers and per-student report
        int present = 0, late = 0, absent = 0;
        Map<Integer, int[]> perStudent = new LinkedHashMap<>();
        for (Attendance a : records) {
            int[] row = perStudent.computeIfAbsent(a.getStudentId(), k -> new int[3]);
            if (Attendance.PRESENT.equals(a.getStatus())) { present++; row[0]++; }
            else if (Attendance.LATE.equals(a.getStatus())) { late++; row[1]++; }
            else { absent++; row[2]++; }
        }
        List<Map<String, Object>> report = new ArrayList<>();
        for (Map.Entry<Integer, int[]> en : perStudent.entrySet()) {
            int[] r = en.getValue();
            int total = r[0] + r[1] + r[2];
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("studentId", en.getKey());
            row.put("present", r[0]);
            row.put("late", r[1]);
            row.put("absent", r[2]);
            row.put("rate", total == 0 ? 0 : Math.round((r[0] + r[1]) * 100f / total));
            report.add(row);
        }

        req.setAttribute("selectableCourses", selectable);
        req.setAttribute("selectedCourse", selected);
        req.setAttribute("records", records);
        req.setAttribute("presentCount", present);
        req.setAttribute("lateCount", late);
        req.setAttribute("absentCount", absent);
        req.setAttribute("rate", InMemoryStore.attendanceRate(records));
        req.setAttribute("report", report);
        WebUtil.render(req, res, "attendance");
    }
}
