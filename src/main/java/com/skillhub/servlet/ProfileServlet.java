package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Use case: Update Profile (Student and Trainer; Admin can also update their own). Also shows session tracking details. */
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        showProfile(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        String action = WebUtil.trim(req.getParameter("action"));
        List<String> errors = new ArrayList<>();

        if ("password".equals(action)) {
            String current = req.getParameter("current");
            String next = req.getParameter("password");
            String confirm = req.getParameter("confirm");
            if (!PasswordUtil.verify(current, user.getPasswordHash())) errors.add("Your current password is incorrect.");
            String problem = Validation.passwordProblem(next);
            if (problem != null) errors.add(problem);
            else if (!next.equals(confirm)) errors.add("New passwords do not match.");
            if (errors.isEmpty()) {
                user.setPasswordHash(PasswordUtil.hash(next));
                store.saveUser(user);
                Flash.success(req, "Your password was changed.");
                WebUtil.redirect(req, res, "/profile");
                return;
            }
        } else {
            User form = new User();
            form.setFullName(WebUtil.trim(req.getParameter("fullName")));
            form.setEmail(WebUtil.trim(req.getParameter("email")));
            form.setPhone(WebUtil.trim(req.getParameter("phone")));
            form.setRole(user.getRole());
            form.setUsername(user.getUsername());
            if (form.getFullName().length() < 3 || form.getFullName().length() > 60) errors.add("Full name must be 3 to 60 characters.");
            if (!Validation.validEmail(form.getEmail())) errors.add("Please enter a valid email address.");
            if (!Validation.validPhone(form.getPhone())) errors.add("Phone number format is invalid.");
            if (errors.isEmpty()) {
                user.setFullName(form.getFullName());
                user.setEmail(form.getEmail());
                user.setPhone(form.getPhone());
                store.saveUser(user);
                Flash.success(req, "Your profile was updated.");
                WebUtil.redirect(req, res, "/profile");
                return;
            }
            req.setAttribute("formUser", form);
        }
        req.setAttribute("errors", errors);
        showProfile(req, res);
    }

    private void showProfile(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession s = req.getSession();
        req.setAttribute("sessionCreated", new Date(s.getCreationTime()));
        req.setAttribute("sessionLastAccess", new Date(s.getLastAccessedTime()));
        req.setAttribute("sessionTimeoutMinutes", s.getMaxInactiveInterval() / 60);
        req.setAttribute("sessionIdShort", s.getId().substring(0, Math.min(8, s.getId().length())) + "...");
        WebUtil.render(req, res, "profile");
    }
}
