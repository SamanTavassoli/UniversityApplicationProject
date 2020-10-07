package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.dao.ApplicationDao;
import com.thesamans.universityapplicationproject.model.users.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Handles the creation of Applications
 * Performs checks such as looking for duplicate applications
 */
@Component
public class ApplicationFactory {

    @Autowired
    ApplicationDao applicationDao;

    /**
     * Start a new application
     * @param studentId StudentId for student that is starting the application
     * @param courseId Course for which application is being started
     * @return the new application if it could be created, otherwise null
     */
    public Application newApplication(int studentId, int courseId) {

        Application application = new Application();

        application.setUserId(studentId);
        application.setCourseId(courseId);
        application.setApplicationStatus(ApplicationStatus.STARTED);

        return application;
    }
    
    /**
     * Does checks on application before it gets created
     * Should be called before creation of new application
     * @param userId user applying
     * @param courseId course being applied to
     * @return true if application meets criteria
     */
    public boolean applicationMeetsCriteria(int userId, int courseId) {

        // this check isn't necessary if user can only apply once
        // check that courseId does not match any other courseId for user's applications
        List<Optional<Application>> applications = applicationDao.findByUserId(userId);
        for (Optional<Application> application : applications) {
            if (application.get().getCourseId() == courseId) {
                return false;
            }
        }

        return true; // TODO: Implement more criteria
    }

}
