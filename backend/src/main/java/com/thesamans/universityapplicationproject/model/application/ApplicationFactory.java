package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.utils.Locator;

/**
 * Handles the creation of Applications
 */
public class ApplicationFactory {

    /**
     * Start a new application
     * @param student Student that is starting the application
     * @param courseId Course for which application is being started
     * @return the new application if it could be created, otherwise null
     */
    public static Application newApplication(Student student, int courseId) {

        if (student.getApplicationsSent().size() >= 5 || !isValidApplication(courseId)) {
            return null;
        }

        Application application = new Application();

        application.setStudentId(student.getStudentId());
        application.setCourseId(courseId);
        application.setApplicationStatus(ApplicationStatus.STARTED);
        application.setApplicationId(generateApplicationId());

        return application;
    }


    public static boolean isValidApplication(int courseId) {
        return Locator.isValidCourseId(courseId);
    }

    private static int generateApplicationId() {
        // todo: implement when database is implemented
        return 0;
    }

}
