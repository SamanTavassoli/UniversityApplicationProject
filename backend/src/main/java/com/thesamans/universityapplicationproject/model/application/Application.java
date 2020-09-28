package com.thesamans.universityapplicationproject.model.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Application that a student makes for a University
 */
@Entity
public class Application {

    /** Number given to the application */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int applicationId;
    /** Id of the student that has applied */
    private int userId;
    /** Id of the Course applied to */
    private int courseId;

    /** Date on which application was submitted by student */
    private Date dateOfApplication;
    /** Date on which the University confirmed they are reviewing the application */
    private Date dateOfReview;
    /** Date on which the University gave their verdict (accepted or rejected) */
    private Date dateOfDecision;

    private ApplicationStatus applicationStatus;


    // Get Set

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
