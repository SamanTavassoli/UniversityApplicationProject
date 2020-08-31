package com.thesamans.universityapplicationproject.model.course;

import com.thesamans.universityapplicationproject.model.users.University;

public class CourseFactory {

    public static Course newCourse(University university, String courseName, int availableSlots, int courseDuration, int fees) {

        if (!canCreateCourse()) {
            return null;
        }

        Course course = new Course();

        course.setUniversity(university);
        course.setCourseName(courseName);
        course.setCourseId(generateCourseId());

        course.setAvailableSlots(availableSlots);
        course.setCourseDuration(courseDuration);
        course.setFees(fees);

        CourseManager.getActiveRegisteredCourses().add(course);

        return course;
    }

    private static int generateCourseId() {
        // todo: implement when database is implemented
        return 0;
    }

    private static boolean canCreateCourse() {
        return false; // todo: implement after course creation specifications are created
    }

}
