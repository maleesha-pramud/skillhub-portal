package com.skillhub.util;

import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Small helpers shared by all servlets. */
public final class WebUtil {
    private WebUtil() { }

    public static InMemoryStore store(ServletContext ctx) {
        return (InMemoryStore) ctx.getAttribute("store");
    }

    public static InMemoryStore store(HttpServletRequest req) {
        return store(req.getServletContext());
    }

    /** The signed-in user, placed on the request by AuthenticationFilter. */
    public static User currentUser(HttpServletRequest req) {
        return (User) req.getAttribute("currentUser");
    }

    /** Forwards to /WEB-INF/jsp/{view}.jsp using a RequestDispatcher. */
    public static void render(HttpServletRequest req, HttpServletResponse res, String view)
            throws ServletException, IOException {
        attachLookups(req);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/" + view + ".jsp");
        rd.forward(req, res);
    }

    public static void redirect(HttpServletRequest req, HttpServletResponse res, String path) throws IOException {
        res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + path));
    }

    public static String trim(String s) {
        return s == null ? "" : s.trim();
    }

    public static int toInt(String s, int def) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    public static double toDouble(String s, double def) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    /** Lookup maps so JSP pages can show names without extra queries. */
    private static void attachLookups(HttpServletRequest req) {
        InMemoryStore store = store(req);
        Map<Integer, String> userNames = new HashMap<>();
        Map<Integer, Integer> enrolByStudent = new HashMap<>();
        Map<Integer, Integer> coursesByTrainer = new HashMap<>();
        Map<Integer, Integer> enrolByCourse = new HashMap<>();
        Map<Integer, Course> courseMap = new HashMap<>();

        for (User u : store.findUsers(null)) {
            userNames.put(u.getId(), u.getFullName());
            if (u.getRole() == Role.STUDENT) enrolByStudent.put(u.getId(), 0);
            if (u.getRole() == Role.TRAINER) coursesByTrainer.put(u.getId(), 0);
        }
        for (Course c : store.findCourses()) {
            courseMap.put(c.getId(), c);
            enrolByCourse.put(c.getId(), 0);
            coursesByTrainer.merge(c.getTrainerId(), 1, Integer::sum);
        }
        for (Enrolment e : store.findEnrolments()) {
            if ("ACTIVE".equals(e.getStatus())) {
                enrolByCourse.merge(e.getCourseId(), 1, Integer::sum);
                enrolByStudent.merge(e.getStudentId(), 1, Integer::sum);
            }
        }
        req.setAttribute("userNames", userNames);
        req.setAttribute("courseMap", courseMap);
        req.setAttribute("enrolByCourse", enrolByCourse);
        req.setAttribute("enrolByStudent", enrolByStudent);
        req.setAttribute("coursesByTrainer", coursesByTrainer);
    }
}
