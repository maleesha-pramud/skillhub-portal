package com.skillhub.servlet;

import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Use case: Logout. Includes "Invalidate Session" and "Redirect to Login". */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate Session
        }
        Flash.success(req, "You have been signed out successfully."); // new session only carries this message
        WebUtil.redirect(req, res, "/login"); // Redirect to Login
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        WebUtil.redirect(req, res, "/dashboard"); // logout is POST-only (protected by the CSRF token)
    }
}
