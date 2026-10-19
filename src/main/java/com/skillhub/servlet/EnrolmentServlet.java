package com.skillhub.servlet;

import com.skillhub.model.Course;
import com.skillhub.model.Enrolment;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Use cases: Enrol in Course (Student), Enrol Student and View Enrolment List (Admin).
 * Access is limited to ADMIN and STUDENT by AuthorizationFilter.
 */
public class EnrolmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        List<Enrolment> list = user.isAdmin() ? store.findEnrolments() : store.enrolmentsByStudent(user.getId());
        req.setAttribute("enrolments", list);
        if (user.isAdmin()) {
            List<Course> active = new ArrayList<>();
            for (Course c : store.findCourses()) {
                if (c.isActive()) active.add(c);
            }
            req.setAttribute("students", store.findUsers(Role.STUDENT));
            req.setAttribute("activeCourses", active);
        }
        WebUtil.render(req, res, "enrolments");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        int courseId = WebUtil.toInt(req.getParameter("courseId"), -1);
        // A student can only enrol themselves; only an admin may choose the student.
        int studentId = user.isAdmin() ? WebUtil.toInt(req.getParameter("studentId"), -1) : user.getId();

        String error = store.enrol(studentId, courseId);
        if (error == null) {
            Course c = store.findCourse(courseId);
            Flash.success(req, user.isAdmin() ? "Student enrolled successfully." : "You are now enrolled in " + c.getTitle() + ".");
        } else {
            Flash.error(req, error);
        }
        WebUtil.redirect(req, res, "/enrolments");
    }
}
