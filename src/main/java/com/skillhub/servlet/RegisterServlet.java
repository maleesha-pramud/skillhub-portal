package com.skillhub.servlet;

import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: Register Account (Student self-registration). */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (!registrationOpen(req)) {
            Flash.error(req, "Online registration is currently closed. Please contact the academy.");
            WebUtil.redirect(req, res, "/login");
            return;
        }
        req.setAttribute("formUser", new User());
        WebUtil.render(req, res, "register");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (!registrationOpen(req)) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        InMemoryStore store = WebUtil.store(req);
        User u = new User();
        u.setFullName(WebUtil.trim(req.getParameter("fullName")));
        u.setUsername(WebUtil.trim(req.getParameter("username")));
        u.setEmail(WebUtil.trim(req.getParameter("email")));
        u.setPhone(WebUtil.trim(req.getParameter("phone")));
        u.setRole(Role.STUDENT);
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");

        List<String> errors = new ArrayList<>();
        if (u.getFullName().length() < 3 || u.getFullName().length() > 60) errors.add("Full name must be 3 to 60 characters.");
        if (!Validation.validUsername(u.getUsername())) errors.add("Username must be 4 to 20 characters (letters, numbers, . _ -).");
        else if (store.usernameTaken(u.getUsername(), 0)) errors.add("That username is already taken.");
        if (!Validation.validEmail(u.getEmail())) errors.add("Please enter a valid email address.");
        if (!Validation.validPhone(u.getPhone())) errors.add("Phone number format is invalid.");
        String pwProblem = Validation.passwordProblem(password);
        if (pwProblem != null) errors.add(pwProblem);
        else if (!password.equals(confirm)) errors.add("Passwords do not match.");

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("formUser", u);
            WebUtil.render(req, res, "register");
            return;
        }
        u.setPasswordHash(PasswordUtil.hash(password));
        store.saveUser(u);
        store.log("New student registered: " + u.getFullName());
        Flash.success(req, "Account created. You can now sign in.");
        WebUtil.redirect(req, res, "/login");
    }

    private boolean registrationOpen(HttpServletRequest req) {
        return Boolean.TRUE.equals(req.getServletContext().getAttribute("registrationOpen"));
    }
}
