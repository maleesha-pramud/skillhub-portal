package com.skillhub.filter;

import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Authentication: only the login page, registration page and static assets are public.
 * Every other URL needs a session that holds a valid "userId". The signed-in user is
 * published as the request attribute "currentUser". Also performs simple session tracking
 * (page view counter and last page visited).
 */
public class AuthenticationFilter implements Filter {
    private static final Set<String> PUBLIC_PATHS = Set.of("/login", "/register", "/index.jsp", "/");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getServletPath();

        if (path.startsWith("/assets/") || PUBLIC_PATHS.contains(path)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        User user = null;
        if (session != null) {
            Object id = session.getAttribute("userId");
            if (id instanceof Integer) {
                InMemoryStore store = WebUtil.store(req);
                user = store.findUser((Integer) id);
                if (user != null && !user.isActive()) {
                    session.removeAttribute("userId");
                    user = null;
                }
            }
        }

        if (user == null) {
            HttpSession s = req.getSession(true);
            if ("GET".equals(req.getMethod())) {
                String target = path + (req.getQueryString() == null ? "" : "?" + req.getQueryString());
                s.setAttribute("postLoginTarget", target);
            }
            Flash.info(req, "Please sign in to continue.");
            res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/login"));
            return;
        }

        // Session tracking
        Integer views = (Integer) session.getAttribute("pageViews");
        session.setAttribute("pageViews", views == null ? 1 : views + 1);
        session.setAttribute("lastPage", path);

        req.setAttribute("currentUser", user);
        chain.doFilter(request, response);
    }
}
