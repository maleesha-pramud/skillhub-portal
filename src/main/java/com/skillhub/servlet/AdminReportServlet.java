package com.skillhub.servlet;

import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: System Administration - View Reports (summary, course utilisation, activity log, CSV export). */
public class AdminReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        if ("csv".equals(req.getParameter("format"))) {
            exportCsv(store, res);
            return;
        }

        ServletContext ctx = req.getServletContext();
        List<Map<String, Object>> rows = new ArrayList<>();
        double revenue = 0;
        for (Course c : store.findCourses()) {
            int enrolled = store.enrolledCount(c.getId());
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("code", c.getCode());
            row.put("title", c.getTitle());
            row.put("trainerId", c.getTrainerId());
            row.put("enrolled", enrolled);
            row.put("capacity", c.getCapacity());
            row.put("pct", c.getCapacity() == 0 ? 0 : Math.min(100, enrolled * 100 / c.getCapacity()));
            row.put("attendance", InMemoryStore.attendanceRate(store.attendanceByCourse(c.getId())));
            row.put("revenue", enrolled * c.getFee());
            revenue += enrolled * c.getFee();
            rows.add(row);
        }
        Date started = (Date) ctx.getAttribute("startedAt");

        req.setAttribute("courseRows", rows);
        req.setAttribute("totalRevenue", revenue);
        req.setAttribute("studentTotal", store.findUsers(Role.STUDENT).size());
        req.setAttribute("trainerTotal", store.findUsers(Role.TRAINER).size());
        req.setAttribute("enrolmentTotal", store.findEnrolments().size());
        req.setAttribute("overallAttendance", InMemoryStore.attendanceRate(store.findAttendance()));
        req.setAttribute("activity", store.recentLog(25));
        req.setAttribute("activeSessions", ctx.getAttribute("activeSessions"));
        req.setAttribute("totalRequests", ctx.getAttribute("totalRequests"));
        req.setAttribute("startedAt", started);
        req.setAttribute("uptimeMinutes", (System.currentTimeMillis() - started.getTime()) / 60000);
        req.setAttribute("serverInfo", ctx.getServerInfo());
        req.setAttribute("javaVersion", System.getProperty("java.version"));
        WebUtil.render(req, res, "reports");
    }

    private void exportCsv(InMemoryStore store, HttpServletResponse res) throws IOException {
        res.setContentType("text/csv; charset=UTF-8");
        res.setHeader("Content-Disposition", "attachment; filename=\"skillhub-enrolments.csv\"");
        PrintWriter out = res.getWriter();
        out.println("Enrolment ID,Student,Course Code,Course Title,Enrolled On,Status");
        for (Enrolment e : store.findEnrolments()) {
            User s = store.findUser(e.getStudentId());
            Course c = store.findCourse(e.getCourseId());
            if (s == null || c == null) continue;
            out.println(e.getId() + "," + csv(s.getFullName()) + "," + csv(c.getCode()) + ","
                    + csv(c.getTitle()) + "," + e.getEnrolledOn() + "," + e.getStatus());
        }
    }

    /** Quotes a value and neutralises spreadsheet formula injection. */
    private String csv(String v) {
        String s = v == null ? "" : v;
        if (!s.isEmpty() && "=+-@".indexOf(s.charAt(0)) >= 0) {
            s = "'" + s;
        }
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}
