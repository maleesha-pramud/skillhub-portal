package com.skillhub.util;

import javax.servlet.http.HttpServletRequest;

/** One-time messages stored in the session and shown after a redirect. */
public final class Flash {
    private Flash() { }

    public static void success(HttpServletRequest req, String msg) { set(req, "success", msg); }
    public static void error(HttpServletRequest req, String msg) { set(req, "danger", msg); }
    public static void info(HttpServletRequest req, String msg) { set(req, "info", msg); }

    private static void set(HttpServletRequest req, String type, String msg) {
        req.getSession(true).setAttribute("flashType", type);
        req.getSession(true).setAttribute("flashMsg", msg);
    }
}
