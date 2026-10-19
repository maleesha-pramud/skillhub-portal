package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.util.Flash;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: System Administration - Configure Application. Changes ServletContext (application scope) settings. */
public class AdminSettingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        WebUtil.render(req, res, "settings");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext ctx = req.getServletContext();
        User admin = WebUtil.currentUser(req);
        String name = WebUtil.trim(req.getParameter("academyName"));
        String email = WebUtil.trim(req.getParameter("supportEmail"));
        int capacity = WebUtil.toInt(req.getParameter("defaultCapacity"), 0);
        boolean open = req.getParameter("registrationOpen") != null;

        List<String> errors = new ArrayList<>();
        if (name.length() < 3 || name.length() > 60) errors.add("Academy name must be 3 to 60 characters.");
        if (!Validation.validEmail(email)) errors.add("Please enter a valid support email.");
        if (capacity < 1 || capacity > 500) errors.add("Default capacity must be between 1 and 500.");
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            WebUtil.render(req, res, "settings");
            return;
        }
        ctx.setAttribute("academyName", name);
        ctx.setAttribute("supportEmail", email);
        ctx.setAttribute("defaultCapacity", capacity);
        ctx.setAttribute("registrationOpen", open);
        WebUtil.store(req).log(admin.getFullName() + " changed the application settings");
        Flash.success(req, "Application settings were saved.");
        WebUtil.redirect(req, res, "/admin/settings");
    }
}
