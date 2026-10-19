package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Use case: Login (Student, Trainer, Admin). */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userId") instanceof Integer
                && WebUtil.store(req).findUser((Integer) session.getAttribute("userId")) != null) {
            WebUtil.redirect(req, res, "/dashboard");
            return;
        }
        WebUtil.render(req, res, "login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        String username = WebUtil.trim(req.getParameter("username"));
        String password = req.getParameter("password");

        if (Validation.isBlank(username) || Validation.isBlank(password)) {
            fail(req, res, username, "Please enter both your username and password.");
            return;
        }
        if (store.isLocked(username)) {
            fail(req, res, username, "Too many failed attempts. Please wait 5 minutes and try again.");
            return;
        }
        User user = store.authenticate(username, password);
        if (user == null) {
            store.recordFailure(username);
            store.log("Failed login attempt for '" + username + "'");
            fail(req, res, username, "Invalid username or password.");
            return;
        }

        store.clearFailures(username);
        req.changeSessionId(); // prevents session fixation
        HttpSession session = req.getSession();
        session.removeAttribute("csrfToken"); // issue a fresh token for the authenticated session
        session.setAttribute("loginTime", new Date());
        session.setAttribute("userId", user.getId());
        Flash.success(req, "Welcome back, " + user.getFullName() + "!");

        String target = (String) session.getAttribute("postLoginTarget");
        session.removeAttribute("postLoginTarget");
        WebUtil.redirect(req, res, target == null || !target.startsWith("/") ? "/dashboard" : target);
    }

    private void fail(HttpServletRequest req, HttpServletResponse res, String username, String message)
            throws ServletException, IOException {
        req.setAttribute("error", message);
        req.setAttribute("username", username);
        WebUtil.render(req, res, "login");
    }
}
