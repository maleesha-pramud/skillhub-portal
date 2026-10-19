package com.skillhub.servlet;

import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.PasswordUtil;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Shared list / add / edit / delete logic for the Manage Students and Manage Trainers use cases. */
public abstract class AbstractPeopleServlet extends HttpServlet {

    protected abstract Role role();
    protected abstract String basePath();   // e.g. /admin/students
    protected abstract String navKey();     // sidebar highlight
    protected abstract String plural();     // "Students"
    protected abstract boolean allowDelete();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        String action = WebUtil.trim(req.getParameter("action"));

        if ("new".equals(action)) {
            User u = new User();
            u.setRole(role());
            showForm(req, res, u, true);
        } else if ("edit".equals(action)) {
            User u = store.findUser(WebUtil.toInt(req.getParameter("id"), -1));
            if (u == null || u.getRole() != role()) {
                res.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            showForm(req, res, u, false);
        } else {
            decorate(req);
            req.setAttribute("people", store.findUsers(role()));
            WebUtil.render(req, res, "people");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User admin = WebUtil.currentUser(req);
        String action = WebUtil.trim(req.getParameter("action"));
        int id = WebUtil.toInt(req.getParameter("id"), 0);

        if ("delete".equals(action)) {
            User u = store.findUser(id);
            if (!allowDelete() || u == null || u.getRole() != role()) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            store.deleteUser(id);
            store.log(admin.getFullName() + " deleted " + role().getLabel().toLowerCase() + " " + u.getFullName());
            Flash.success(req, u.getFullName() + " was deleted.");
            WebUtil.redirect(req, res, basePath());
            return;
        }

        User existing = id == 0 ? null : store.findUser(id);
        if (id != 0 && (existing == null || existing.getRole() != role())) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        User form = new User();
        form.setId(id);
        form.setRole(role());
        form.setFullName(WebUtil.trim(req.getParameter("fullName")));
        form.setUsername(WebUtil.trim(req.getParameter("username")));
        form.setEmail(WebUtil.trim(req.getParameter("email")));
        form.setPhone(WebUtil.trim(req.getParameter("phone")));
        form.setActive(req.getParameter("active") != null);
        String password = req.getParameter("password");

        List<String> errors = new ArrayList<>();
        if (form.getFullName().length() < 3 || form.getFullName().length() > 60) errors.add("Full name must be 3 to 60 characters.");
        if (!Validation.validUsername(form.getUsername())) errors.add("Username must be 4 to 20 characters (letters, numbers, . _ -).");
        else if (store.usernameTaken(form.getUsername(), id)) errors.add("That username is already taken.");
        if (!Validation.validEmail(form.getEmail())) errors.add("Please enter a valid email address.");
        if (!Validation.validPhone(form.getPhone())) errors.add("Phone number format is invalid.");
        boolean passwordGiven = !Validation.isBlank(password);
        if (id == 0 || passwordGiven) {
            String problem = Validation.passwordProblem(password);
            if (problem != null) errors.add(problem);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            showForm(req, res, form, id == 0);
            return;
        }
        if (existing != null) {
            form.setCreatedAt(existing.getCreatedAt());
            form.setPasswordHash(passwordGiven ? PasswordUtil.hash(password) : existing.getPasswordHash());
        } else {
            form.setPasswordHash(PasswordUtil.hash(password));
        }
        store.saveUser(form);
        store.log(admin.getFullName() + (id == 0 ? " added " : " updated ") + role().getLabel().toLowerCase() + " " + form.getFullName());
        Flash.success(req, form.getFullName() + (id == 0 ? " was added." : " was updated."));
        WebUtil.redirect(req, res, basePath());
    }

    private void showForm(HttpServletRequest req, HttpServletResponse res, User person, boolean isNew)
            throws ServletException, IOException {
        decorate(req);
        req.setAttribute("person", person);
        req.setAttribute("isNew", isNew);
        WebUtil.render(req, res, "person-form");
    }

    private void decorate(HttpServletRequest req) {
        req.setAttribute("basePath", basePath());
        req.setAttribute("navKey", navKey());
        req.setAttribute("plural", plural());
        req.setAttribute("singular", role().getLabel());
        req.setAttribute("allowDelete", allowDelete());
        req.setAttribute("isStudentList", role() == Role.STUDENT);
    }
}
