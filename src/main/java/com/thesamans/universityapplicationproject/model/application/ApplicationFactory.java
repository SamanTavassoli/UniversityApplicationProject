package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.model.utils.Locator;

/**
 * Handles the creation of Applications
 */
public class ApplicationFactory {

    public static Application newApplication(int studentId, int courseId) {
        Application application = new Application();

        checkApplicationValidity(studentId, courseId);

        application.setStudentId(studentId);
        application.setCourseId(courseId);
        application.setApplicationStatus(ApplicationStatus.STARTED);

        return application;
    }

    public static boolean checkApplicationValidity(int studentId, int courseId) {
        return Locator.isValidStudentId(studentId)
                & Locator.isValidCourseId(courseId);
    }

}
