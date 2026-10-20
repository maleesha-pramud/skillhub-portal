package com.skillhub.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/** Counts every request handled since the application started (shown on the admin reports page). */
public class RequestStatsListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext ctx = sre.getServletContext();
        if (sre.getServletRequest() instanceof HttpServletRequest) {
            synchronized (ctx) {
                Long total = (Long) ctx.getAttribute("totalRequests");
                if (total != null) {
                    ctx.setAttribute("totalRequests", total + 1);
                }
            }
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // not needed
    }
}
