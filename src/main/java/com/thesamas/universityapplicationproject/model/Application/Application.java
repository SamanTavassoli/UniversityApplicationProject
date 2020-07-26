package com.thesamas.universityapplicationproject.model.Application;

import com.thesamas.universityapplicationproject.model.objects.Course;
import com.thesamas.universityapplicationproject.model.users.University;

import java.util.Date;

/**
 * Application that a student makes for a University
 */
public class Application {

    /** Id of the student that has applied */
    private int studentId;
    /** University applied to */
    private University university;
    /** Course applied to */
    private Course course;

    /** Date on which application was submitted by student */
    private Date dateOfApplication;
    /** Date on which the University confirmed they are reviewing the application */
    private Date dateOfReview;
    /** Date on which the University gave their verdict (accepted or rejected) */
    private Date dateOfVerdict;

    private ApplicationStatus applicationStatus;


    // Get Set


    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
