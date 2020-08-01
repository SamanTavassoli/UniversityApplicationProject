package com.thesamans.universityapplicationproject.model.application;

import java.util.Date;

/**
 * Application that a student makes for a University
 */
public class Application {

    /** Id of the student that has applied */
    private int studentId;
    /** Id of the Course applied to */
    private int courseId;
    /** Number given to the application */
    private int applicationId;

    /** Date on which application was submitted by student */
    private Date dateOfApplication;
    /** Date on which the University confirmed they are reviewing the application */
    private Date dateOfReview;
    /** Date on which the University gave their verdict (accepted or rejected) */
    private Date dateOfDecision;

    private ApplicationStatus applicationStatus;


    // Get Set

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationNumber) {
        this.applicationId = applicationNumber;
    }

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public Date getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public Date getDateOfDecision() {
        return dateOfDecision;
    }

    public void setDateOfDecision(Date dateOfDecision) {
        this.dateOfDecision = dateOfDecision;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
