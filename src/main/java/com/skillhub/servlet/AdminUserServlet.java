package com.skillhub.servlet;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Use case: System Administration - Manage Users (activate / deactivate accounts, reset passwords). */
public class AdminUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("users", WebUtil.store(req).findUsers(null));
        WebUtil.render(req, res, "users");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User admin = WebUtil.currentUser(req);
        User target = store.findUser(WebUtil.toInt(req.getParameter("id"), -1));
        String action = WebUtil.trim(req.getParameter("action"));

        if (target == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        if ("toggle".equals(action)) {
            if (target.getId() == admin.getId()) {
                Flash.error(req, "You cannot deactivate your own account.");
            } else {
                target.setActive(!target.isActive());
                store.log(admin.getFullName() + (target.isActive() ? " activated " : " deactivated ") + target.getUsername());
                Flash.success(req, target.getFullName() + (target.isActive() ? " was activated." : " was deactivated."));
            }
        } else if ("reset".equals(action)) {
            String temp = PasswordUtil.randomPassword(10);
            target.setPasswordHash(PasswordUtil.hash(temp));
            store.log(admin.getFullName() + " reset the password for " + target.getUsername());
            Flash.success(req, "Temporary password for " + target.getUsername() + ": " + temp + "  (shown once, share it securely)");
        } else {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        WebUtil.redirect(req, res, "/admin/users");
    }
}
