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
 * Generic class to handle students, universities and admins
 * Handles the appropriate level of detail to be added and retrieved to the userDao based on the type of user
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    public String getStudentUsername(int studentId) {
        return userDao.findById(studentId).get().getUsername();
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

    public List<Integer> getConsideredCourses(int studentId) {
        Student student = (Student) userDao.findById(studentId).get();
        return student.getCoursesConsidered();
    }

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

    public boolean isConsideredCourse(int courseId, int userId) {
        Student student = (Student) getUser(UserType.STUDENT, userId);
        return !Objects.isNull(student)
                && courseDao.existsByCourseId(courseId)
                && student.getCoursesConsidered().contains(courseId);
    }

    public List<User> getUserList() {
        return userDao.findAll();
    }

    public boolean deleteUser(int userId) {
        if (userDao.existsById(userId)) {
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<UniversityPublicInfo> getAllUniversityPublicInfo() {
        List<UniversityPublicInfo> universityPublicInfo = userDao.findAll().stream()
                .filter(user -> user instanceof University)
                .map(user -> new UniversityPublicInfo(user.getUsername(), user.getUserId()))
                .collect(Collectors.toList());
        return universityPublicInfo;
    }

    public UniversityPublicInfo getUniversityPublicInfo(int universityId) {
        University university = (University) userDao.findById(universityId).get();
        return new UniversityPublicInfo(university.getUsername(), universityId);
    }

}
