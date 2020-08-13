package com.thesamans.universityapplicationproject.model.course;

import com.thesamans.universityapplicationproject.model.application.Application;
import com.thesamans.universityapplicationproject.model.users.University;

import java.util.ArrayList;

public class Course {

    private int courseId;
    private University university;
    private String courseName;

    /** Maximum number of students that the course can take */
    private int availableSlots;
    /** Number of years the course will take to complete */
    private int courseDuration;
    /** Yearly fees for this course */
    private int fees;

    private ArrayList<Application> applicationsReceived;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public ArrayList<Application> getApplicationsReceived() {
        return applicationsReceived;
    }

    public void setApplicationsReceived(ArrayList<Application> applicationsReceived) {
        this.applicationsReceived = applicationsReceived;
    }
}
