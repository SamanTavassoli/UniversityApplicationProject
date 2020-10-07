package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Provides services related to users
 * Users controller directly calls this service
 * Handles the appropriate level of detail to be added and retrieved to the userDao based on the type of user
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    // ------------- Getters

    // all users

    public List<User> getUserList() {
        return userDao.findAll();
    }

    /**
     * Looks for a specific user in database
     * @param userId User Id for the user requested
     * @param <T> Type of user requested
     * @return returns the casted user object if the retrieved user is of specified type, otherwise null
     */
    public <T extends User> T getUser(UserType userType, int userId) {
        Optional<User> user = userDao.findById(userId);

        if (user.isEmpty()) {
            System.err.println("No such user");
            return null;
        }

        // check if retrieved class is specified class
        // wasn't gonna spend forever finding the method that gives just the class cause I'm getting:
        // com.thesamans.universityapplicationproject.model.users.Admin
        // just getting the last string after the last dot
        String fullClassName = user.get().getClass().getName();
        String classToCaps = fullClassName.substring(fullClassName.lastIndexOf(".") + 1).toUpperCase();
        if (classToCaps.equals(userType.name())) {
            return (T) user.get();
        } else {
            return null;
        }
    }

    /**
     * Admin method
     * This does the same as above but isn't given a user type to check against as an extra security step
     */
    public User getUser(int userId) {
        Optional<User> user = userDao.findById(userId);

        if (user.isEmpty()) {
            System.err.println("No such user");
            return null;
        }

        return user.get();
    }

    // students

    /**
     * Returns the student's username given a student Id
     */
    public String getStudentUsername(int studentId) {
        return userDao.findById(studentId).get().getUsername();
    }

    /**
     * Returns the courses that the student is considering at the moment given a student Id
     */
    public List<Integer> getConsideredCourses(int studentId) {
        Student student = (Student) userDao.findById(studentId).get();
        return student.getCoursesConsidered();
    }

    // universities

    /**
     * Returns the public information related to all registered universities
     * This kind of method is typically called when displaying a list of all the universities
     * such as on the search page of the website
     */
    public List<UniversityPublicInfo> getAllUniversityPublicInfo() {
        List<UniversityPublicInfo> universityPublicInfo = userDao.findAll().stream()
                .filter(user -> user instanceof University)
                .map(user -> new UniversityPublicInfo(user.getUsername(), user.getUserId()))
                .collect(Collectors.toList());
        return universityPublicInfo;
    }

    /**
     * Returns the public information related to a particular university given a university Id
     */
    public UniversityPublicInfo getUniversityPublicInfo(int universityId) {
        University university = (University) userDao.findById(universityId).get();
        return new UniversityPublicInfo(university.getUsername(), universityId);
    }

    // ------------- Considered courses manipulation for students

    /**
     * Adds a courseId to a student's list of considered courses
     * The course must be valid
     * The student must exist
     * The student must not already have that course in their considered courses
     * @return true if course was added to considered courses for student
     */
    public boolean addToConsideredCourses(int courseId, int userId) {
        Student student = (Student) getUser(UserType.STUDENT, userId);
        if (!Objects.isNull(student)
                && courseDao.existsByCourseId(courseId)
                && !student.getCoursesConsidered().contains(courseId)) {
            if (Objects.isNull(student.getCoursesConsidered())) {
                student.setCoursesConsidered(new ArrayList<>());
            }
            student.getCoursesConsidered().add(courseId);
            userDao.save(student);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a course from a user's list of considered courses,
     * given a user Id and a course Id for the course to be removed
     *
     * Performs checks to make sure course and student exist and that the course is
     * in the student's courses considered list
     */
    public boolean removeFromConsideredCourses(int courseId, int userId) {
        Student student = (Student) getUser(UserType.STUDENT, userId);
        if (!Objects.isNull(student)
                && courseDao.existsByCourseId(courseId)
                && student.getCoursesConsidered().contains(courseId)) {
            student.getCoursesConsidered().remove(student.getCoursesConsidered().indexOf(courseId));
            userDao.save(student);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the course specified by the course Id is in the student's list of considered
     * courses given their user Id
     */
    public boolean isConsideredCourse(int courseId, int userId) {
        Student student = (Student) getUser(UserType.STUDENT, userId);
        return !Objects.isNull(student)
                && courseDao.existsByCourseId(courseId)
                && student.getCoursesConsidered().contains(courseId);
    }

    // ------------- User removal

    public boolean deleteUser(int userId) {
        if (userDao.existsById(userId)) {
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }

}
