package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

public class ApplicationManager {

    @Autowired
    UserDao userDao;

    public boolean sendApplication(Application application) {

        Student student = (Student) userDao.findById(application.getUserId()).get();
        Course course = new Course(); // TODO : Implement fetch of actual course

        Objects.requireNonNull(student);
        Objects.requireNonNull(course);

        if (!ApplicationMeetsCriteria(application)) return false;

        Date applicationDate = new Date();
        application.setDateOfApplication(applicationDate);
        application.setApplicationStatus(ApplicationStatus.APPLIED);

        // TODO: add application to application dao
        course.getApplicationsReceived().add(application);

        return true;
    }

    /**
     * Called when a University has received the application and has declared that it is under review
     * @param application application that has been received
     */
    public void applicationInReview(Application application) {
        Date reviewDate = new Date();
        application.setApplicationStatus(ApplicationStatus.IN_REVIEW);
        application.setDateOfReview(reviewDate);

    }

    /**
     * Called when a University has made their decision on an application
     * @param application application on which decision has been made
     * @param applicationStatus Accepted or Rejected
     */
    public void applicationDecisionMade(Application application, ApplicationStatus applicationStatus) {
        Date decisionDate = new Date();
        application.setApplicationStatus(applicationStatus);
        application.setDateOfDecision(decisionDate);
    }

    private ApplicationStatus changeStatus(Application application, ApplicationStatus status) {
        application.setApplicationStatus(status);
        return application.getApplicationStatus();
    }

    /**
     * Checks that the minimum fields required for an applications are at least populated
     * @param application application being checked
     * @return true if the application conforms to checklist
     */
    private boolean ApplicationMeetsCriteria(Application application) {
        return false; // todo: implement when criteria for application are created
    }
}
