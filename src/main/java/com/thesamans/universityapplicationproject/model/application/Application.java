package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.model.objects.Course;
import com.thesamans.universityapplicationproject.model.users.University;

import java.util.Date;

/**
 * Application that a student makes for a University
 */
public class Application {

    /** Id of the student that has applied */
    private int studentId;
    /** Id of the Course applied to */
    private int courseId;

    /** Date on which application was submitted by student */
    private Date dateOfApplication;
    /** Date on which the University confirmed they are reviewing the application */
    private Date dateOfReview;
    /** Date on which the University gave their verdict (accepted or rejected) */
    private Date dateOfVerdict;

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

    public Date getDateOfVerdict() {
        return dateOfVerdict;
    }

    public void setDateOfVerdict(Date dateOfVerdict) {
        this.dateOfVerdict = dateOfVerdict;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
