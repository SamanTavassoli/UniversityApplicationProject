package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.ApplicationDao;
import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.application.Application;
import com.thesamans.universityapplicationproject.model.application.ApplicationFactory;
import com.thesamans.universityapplicationproject.model.application.ApplicationManager;
import com.thesamans.universityapplicationproject.model.application.ApplicationStatus;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.Student;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Provides services related to applications
 * Application controller directly calls this service
 */
@Service
public class ApplicationService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ApplicationDao applicationDao;

    @Autowired
    ApplicationManager applicationManager;

    @Autowired
    ApplicationFactory applicationFactory;

    // ------------- Getters

    /**
     * Returns a list of applications from applicants to the specified course
     */
    public List<Application> getApplicationsForCourse(int courseId) {

        ArrayList<Application> applications = new ArrayList<Application>();
        List<Optional<Application>> optApplications = applicationDao.findByCourseId(courseId);
//        for (Optional<Application> optApplication : optApplications) {
//            applications.add(optApplication.get());
//        }
        return optApplications.stream().map(Optional::get).collect(Collectors.toList());
    }

    /**
     * Returns an application given it's application Id
     */
    public Application getApplicationForId(int applicationId) {
        return applicationDao.findByApplicationId(applicationId).get();
    }

    /**
     * Returns a list of applications that the student has made based on their userId
     */
    public List<Application> getApplicationsForStudent(int userId) {
        return applicationDao.findAllByUserId(userId);
    }

    // ------------- Methods requiring application manipulation delegated to Application Manager

    /**
     * Creates Application through application factory,
     * Sends Applications to courses through application manager
     * Sets the user's hasApplied status to true
     * @param userId user applying
     * @param courseIds course ids for courses that the user wants to apply to
     * @return true if all applications could go through
     */
    public boolean sendApplications(int userId, int[] courseIds) {

        ArrayList<Application> applications = new ArrayList<>();

        for (int courseId : courseIds) {
            if (!applicationFactory.applicationMeetsCriteria(userId, courseId)) {
                return false;
            }
            applications.add(applicationFactory.newApplication(userId, courseId));
        }

        // create all applications first to make sure they are all valid and then send them
        for (Application application : applications) {
            applicationManager.sendApplication(application);
        }

        return true;
    }

    public boolean setApplicationToInReview(int applicationId) {
        return applicationManager.applicationInReview(applicationId);
    }

    public boolean setApplicationDecisionMade(int applicationId, boolean accepted) {
        ApplicationStatus applicationStatus;
        if (accepted) {
            applicationStatus = ApplicationStatus.ACCEPTED;
        } else {
            applicationStatus = ApplicationStatus.REJECTED;
        }
        return applicationManager.applicationDecisionMade(applicationId, applicationStatus);
    }

    public void resetApplication(int applicationId) {
        applicationManager.resetApplication(applicationId);
    }

    public boolean deleteApplication(int applicationId) {
        return applicationManager.deleteApplication(applicationId);
    }

}
