package com.thesamans.universityapplicationproject.model.utils;

import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.University;

public class Locator {

    /**
     * Checks if the student id corresponds to a student in the database
     * @param studentId course to check
     * @return true if course is present in the database
     */
    public static boolean isValidStudentId(int studentId) {
        return false; // todo: implement when database is put in place
    }

    /**
     * Checks if the course id corresponds to a course in the database
     * @param courseId course to check
     * @return true if course is present in the database
     */
    public static boolean isValidCourseId(int courseId) {
        return false; // todo: implement when database is put in place
    }

    /**
     * Checks if the university id corresponds to a university in the database
     * @param universityId university to check
     * @return true if university is present in the database
     */
    public static boolean isValidUniversityId(int universityId) {
        return false; // todo: implement when database is put in place
    }

    public static Student getStudent(int studentId) {
        return null; // todo: implement when database is put in place
    }

    public static Course getCourse(int courseId) {
        return null; // todo: implement when database is put in place
    }

    public static University getUniversity(int universityId) {
        return null; // todo: implement when database is put in place
    }

}
