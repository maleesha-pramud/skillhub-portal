package com.skillhub.listener;

import com.skillhub.store.InMemoryStore;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Runs once when the web application starts. Creates the in-memory store, loads the demo data
 * and publishes application-wide settings in the ServletContext (application scope).
 */
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        InMemoryStore store = new InMemoryStore();
        store.seed();

        ctx.setAttribute("store", store);
        ctx.setAttribute("academyName", valueOr(ctx.getInitParameter("academyName"), "SkillHub Training Academy"));
        ctx.setAttribute("supportEmail", valueOr(ctx.getInitParameter("supportEmail"), "support@skillhub.lk"));
        ctx.setAttribute("defaultCapacity", Integer.parseInt(valueOr(ctx.getInitParameter("defaultCapacity"), "30")));
        ctx.setAttribute("registrationOpen", Boolean.parseBoolean(valueOr(ctx.getInitParameter("registrationOpen"), "true")));
        ctx.setAttribute("startedAt", new Date());
        ctx.setAttribute("activeSessions", new AtomicInteger(0));
        ctx.setAttribute("totalRequests", new AtomicLong(0));

        ctx.log("SkillHub portal initialised with demo data.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("SkillHub portal stopped. In-memory data discarded.");
    }

    private static String valueOr(String v, String def) {
        return v == null || v.isBlank() ? def : v;
    }
}
