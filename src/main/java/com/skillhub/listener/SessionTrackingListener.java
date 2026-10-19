package com.skillhub.listener;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Session tracking. Counts live sessions and writes sign-in / sign-out events to the activity log.
 * A session counts as a sign-in when the "userId" attribute is added to it.
 */
public class SessionTrackingListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        counter(se.getSession().getServletContext()).incrementAndGet();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        AtomicInteger c = counter(se.getSession().getServletContext());
        if (c.get() > 0) {
            c.decrementAndGet();
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("userId".equals(event.getName())) {
            describe(event, "signed in");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("userId".equals(event.getName())) {
            describe(event, "signed out");
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // not needed
    }

    private void describe(HttpSessionBindingEvent event, String action) {
        ServletContext ctx = event.getSession().getServletContext();
        InMemoryStore store = WebUtil.store(ctx);
        if (store == null || !(event.getValue() instanceof Integer)) return;
        User u = store.findUser((Integer) event.getValue());
        if (u != null) {
            store.log(u.getFullName() + " (" + u.getRole().getLabel() + ") " + action);
        }
    }

    private AtomicInteger counter(ServletContext ctx) {
        return (AtomicInteger) ctx.getAttribute("activeSessions");
    }
}
