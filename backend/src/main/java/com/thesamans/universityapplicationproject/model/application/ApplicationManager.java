package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.dao.ApplicationDao;
import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Component
public class ApplicationManager {

    @Autowired
    CourseDao courseDao;

    @Autowired
    ApplicationDao applicationDao;

    /**
     * Adds application to course's list
     * Saves the application in the applicationDao
     * @param application application to be sent
     */
    public void sendApplication(Application application) {

        Course course = courseDao.findById(application.getCourseId()).get();

        Date applicationDate = new Date();
        application.setDateOfApplication(applicationDate);
        application.setApplicationStatus(ApplicationStatus.APPLIED);

        applicationDao.save(application);
        courseDao.save(course);
    }

    /**
     * Deletes an application
     *
     *
     *
     * @param applicationId application to remove
     * @return true if application was removed
     */
    public boolean deleteApplication(int applicationId) {
        Optional<Application> application = applicationDao.findByApplicationId(applicationId);
        if (application.isPresent()) {
            applicationDao.delete(application.get());
            return true;
        }
        return false;
    }

    // ------------- Setting application status methods

    /**
     * Finds the application through the application Id and sets it to in review for that date
     */
    public boolean applicationInReview(int applicationId) {
        Application application = applicationDao.findByApplicationId(applicationId).get();
        Date reviewDate = new Date();
        application.setApplicationStatus(ApplicationStatus.IN_REVIEW);
        application.setDateOfReview(reviewDate);
        applicationDao.save(application);
        return true; // can return false if setting application in review fails
    }

    /**
     * Called when a University has made their decision on an application
     * @param applicationId application on which decision has been made
     * @param applicationStatus Accepted or Rejected
     */
    public boolean applicationDecisionMade(int applicationId, ApplicationStatus applicationStatus) {
        Application application = applicationDao.findByApplicationId(applicationId).get();
        Date decisionDate = new Date();
        application.setApplicationStatus(applicationStatus);
        application.setDateOfDecision(decisionDate);
        applicationDao.save(application);
        return true; // can return false if setting fails
    }

    /**
     * Sets the applications status back to APPLIED
     * The dates of review and decision are erased as they are no longer applicable
     * @param applicationId application to reset
     */
    public void resetApplication(int applicationId) {
        Application application = applicationDao.findByApplicationId(applicationId).get();
        application.setApplicationStatus(ApplicationStatus.APPLIED);
        application.setDateOfReview(null);
        application.setDateOfDecision(null);
        applicationDao.save(application);
    }

}
