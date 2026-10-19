package com.skillhub.model;

/** The three actor types shown in the use case diagram. */
public enum Role {
    ADMIN("Administrator"),
    TRAINER("Trainer"),
    STUDENT("Student");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
