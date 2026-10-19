package com.skillhub.servlet;

import com.skillhub.model.Role;

/** Use case: Manage Trainers (Add, Edit, View Trainer List). */
public class AdminTrainerServlet extends AbstractPeopleServlet {
    @Override protected Role role() { return Role.TRAINER; }
    @Override protected String basePath() { return "/admin/trainers"; }
    @Override protected String navKey() { return "trainers"; }
    @Override protected String plural() { return "Trainers"; }
    @Override protected boolean allowDelete() { return false; }
}
