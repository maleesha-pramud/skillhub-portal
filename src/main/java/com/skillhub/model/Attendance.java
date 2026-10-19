package com.skillhub.model;

import java.time.LocalDate;

/** One student's attendance for one course session. Status: PRESENT, LATE or ABSENT. */
public class Attendance {
    public static final String PRESENT = "PRESENT";
    public static final String LATE = "LATE";
    public static final String ABSENT = "ABSENT";

    private int id;
    private int courseId;
    private int studentId;
    private LocalDate date;
    private String status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
