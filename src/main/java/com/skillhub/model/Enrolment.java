package com.skillhub.model;

import java.time.LocalDate;

/** Links one student to one course. */
public class Enrolment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrolledOn = LocalDate.now();
    private String status = "ACTIVE";

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public LocalDate getEnrolledOn() { return enrolledOn; }
    public void setEnrolledOn(LocalDate enrolledOn) { this.enrolledOn = enrolledOn; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
