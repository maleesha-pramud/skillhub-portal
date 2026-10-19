package com.skillhub.servlet;

import com.skillhub.model.Course;
import com.skillhub.model.Role;
import com.skillhub.model.User;
import com.skillhub.store.InMemoryStore;
import com.skillhub.util.Flash;
import com.skillhub.util.Validation;
import com.skillhub.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Use cases: View Courses (all roles), Add Course and Edit Course (Admin only),
 * View Assigned Courses (Trainer sees only their own courses).
 */
public class CourseServlet extends HttpServlet {
    private static final String[] CATEGORIES = {"Technology", "Business", "Professional Development", "Languages"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        String action = WebUtil.trim(req.getParameter("action"));

        if ("new".equals(action) || "edit".equals(action)) {
            if (!user.isAdmin()) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
            Course course = new Course();
            course.setCapacity((Integer) req.getServletContext().getAttribute("defaultCapacity"));
            course.setDurationWeeks(8);
            if ("edit".equals(action)) {
                course = store.findCourse(WebUtil.toInt(req.getParameter("id"), -1));
                if (course == null) {
                    res.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }
            }
            showForm(req, res, store, course);
            return;
        }

        List<Course> list;
        if (user.isTrainer()) {
            list = store.coursesByTrainer(user.getId());
        } else if (user.isStudent()) {
            list = new ArrayList<>();
            for (Course c : store.findCourses()) {
                if (c.isActive()) list.add(c);
            }
            Set<Integer> enrolled = new HashSet<>();
            for (Course c : list) {
                if (store.isEnrolled(user.getId(), c.getId())) enrolled.add(c.getId());
            }
            req.setAttribute("enrolledIds", enrolled);
        } else {
            list = store.findCourses();
        }
        req.setAttribute("courses", list);
        WebUtil.render(req, res, "courses");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        InMemoryStore store = WebUtil.store(req);
        User user = WebUtil.currentUser(req);
        if (!user.isAdmin()) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        int id = WebUtil.toInt(req.getParameter("id"), 0);
        Course existing = id == 0 ? null : store.findCourse(id);

        if ("toggle".equals(WebUtil.trim(req.getParameter("action")))) {
            if (existing == null) {
                res.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            existing.setActive(!existing.isActive());
            store.log(user.getFullName() + (existing.isActive() ? " activated course " : " deactivated course ") + existing.getCode());
            Flash.success(req, "Course " + existing.getCode() + (existing.isActive() ? " was activated." : " was deactivated."));
            WebUtil.redirect(req, res, "/courses");
            return;
        }

        Course c = new Course();
        c.setId(id);
        c.setCode(WebUtil.trim(req.getParameter("code")).toUpperCase());
        c.setTitle(WebUtil.trim(req.getParameter("title")));
        c.setCategory(WebUtil.trim(req.getParameter("category")));
        c.setDescription(WebUtil.trim(req.getParameter("description")));
        c.setTrainerId(WebUtil.toInt(req.getParameter("trainerId"), 0));
        c.setDurationWeeks(WebUtil.toInt(req.getParameter("durationWeeks"), 0));
        c.setCapacity(WebUtil.toInt(req.getParameter("capacity"), 0));
        c.setFee(WebUtil.toDouble(req.getParameter("fee"), -1));
        c.setSchedule(WebUtil.trim(req.getParameter("schedule")));
        c.setActive(existing == null || existing.isActive());

        List<String> errors = new ArrayList<>();
        if (!c.getCode().matches("^[A-Z0-9]{4,10}$")) errors.add("Course code must be 4 to 10 letters or numbers.");
        else if (store.courseCodeTaken(c.getCode(), id)) errors.add("That course code already exists.");
        if (c.getTitle().length() < 3 || c.getTitle().length() > 80) errors.add("Title must be 3 to 80 characters.");
        if (!java.util.Arrays.asList(CATEGORIES).contains(c.getCategory())) errors.add("Please choose a valid category.");
        User trainer = store.findUser(c.getTrainerId());
        if (trainer == null || trainer.getRole() != Role.TRAINER) errors.add("Please assign a trainer.");
        if (c.getDurationWeeks() < 1 || c.getDurationWeeks() > 52) errors.add("Duration must be between 1 and 52 weeks.");
        if (c.getCapacity() < 1 || c.getCapacity() > 500) errors.add("Capacity must be between 1 and 500.");
        else if (id != 0 && c.getCapacity() < store.enrolledCount(id)) errors.add("Capacity cannot be lower than the current number of enrolled students.");
        if (c.getFee() < 0) errors.add("Fee must be zero or more.");
        if (Validation.isBlank(c.getSchedule())) errors.add("Please enter the class schedule.");
        if (c.getDescription().length() > 300) errors.add("Description must be 300 characters or fewer.");

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            showForm(req, res, store, c);
            return;
        }
        store.saveCourse(c);
        store.log(user.getFullName() + (id == 0 ? " added course " : " updated course ") + c.getCode());
        Flash.success(req, "Course " + c.getCode() + (id == 0 ? " was added." : " was updated."));
        WebUtil.redirect(req, res, "/courses");
    }

    private void showForm(HttpServletRequest req, HttpServletResponse res, InMemoryStore store, Course c)
            throws ServletException, IOException {
        req.setAttribute("course", c);
        req.setAttribute("trainers", store.findUsers(Role.TRAINER));
        req.setAttribute("categories", CATEGORIES);
        WebUtil.render(req, res, "course-form");
    }
}
