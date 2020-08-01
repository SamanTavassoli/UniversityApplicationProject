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
        Application application = new Application();

        checkApplicationValidity(student.getStudentId(), courseId);

        if (student.getApplicationsSent().size() >= 5) {
            return null;
        }

        application.setStudentId(student.getStudentId());
        application.setCourseId(courseId);
        application.setApplicationStatus(ApplicationStatus.STARTED);

        return application;
    }


    public static boolean checkApplicationValidity(int studentId, int courseId) {
        return Locator.isValidStudentId(studentId)
                & Locator.isValidCourseId(courseId);
    }

}
