package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.model.users.Student;

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

        // TODO: check max 5 application

        Application application = new Application();

        application.setUserId(student.getUserId());
        application.setCourseId(courseId);
        application.setApplicationStatus(ApplicationStatus.STARTED);
        application.setApplicationId(generateApplicationId());

        return application;
    }


    public static boolean isValidApplication(int courseId) {
        return true; // TODO: Implement
    }

    private static int generateApplicationId() {
        // todo: implement when database is implemented
        return 0;
    }

}
