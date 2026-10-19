package com.skillhub.filter;

import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authorisation (role based access control). Runs after AuthenticationFilter.
 * URLs not listed here are open to every signed-in user.
 */
public class AuthorizationFilter implements Filter {
    private final Map<String, Set<Role>> rules = new LinkedHashMap<>();

    @Override
    public void init(javax.servlet.FilterConfig config) {
        rules.put("/admin/", EnumSet.of(Role.ADMIN));
        rules.put("/attendance/mark", EnumSet.of(Role.ADMIN));
        rules.put("/enrolments", EnumSet.of(Role.ADMIN, Role.STUDENT));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        User user = WebUtil.currentUser(req);

        if (user != null) { // null means a public URL
            String path = req.getServletPath();
            for (Map.Entry<String, Set<Role>> rule : rules.entrySet()) {
                boolean match = rule.getKey().endsWith("/") ? path.startsWith(rule.getKey()) : path.equals(rule.getKey());
                if (match && !rule.getValue().contains(user.getRole())) {
                    InMemoryStore store = WebUtil.store(req);
                    store.log("ACCESS DENIED: " + user.getUsername() + " tried " + path);
                    res.sendError(HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }
}
