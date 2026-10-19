package com.skillhub.listener;

import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/** Counts every request handled since the application started (shown on the admin reports page). */
public class RequestStatsListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        AtomicLong total = (AtomicLong) sre.getServletContext().getAttribute("totalRequests");
        if (total != null && sre.getServletRequest() instanceof HttpServletRequest) {
            total.incrementAndGet();
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // not needed
    }
}
