package com.skillhub.servlet;

import com.skillhub.model.Role;

/** Use case: Manage Students (Add, Edit, Delete, View Student List). */
public class AdminStudentServlet extends AbstractPeopleServlet {
    @Override protected Role role() { return Role.STUDENT; }
    @Override protected String basePath() { return "/admin/students"; }
    @Override protected String navKey() { return "students"; }
    @Override protected String plural() { return "Students"; }
    @Override protected boolean allowDelete() { return true; }
}
