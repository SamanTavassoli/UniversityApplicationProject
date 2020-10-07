package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.MyUserDetails;
import com.thesamans.universityapplicationproject.model.users.University;
import com.thesamans.universityapplicationproject.model.users.UniversityPublicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    public Course getCourse(int courseId) {
        return courseDao.findById(courseId).get();
    }

    public List<Course> getAllCoursesForUni(int universityId) {
        return getAllCourses().stream().filter(course -> course.getUniversityId() == universityId).collect(Collectors.toList());
    }

    /** Returns all courses for all universities */
    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    /**
     * Adds a course if not other course shares that course name
     * The uni specified by course must be authenticated
     * Adds course to course dao
     * @return true if did add
     */
    public boolean addCourse(Course course) {
        University university = (University) userDao.findById(course.getUniversityId()).get();
        String universityFromDAO = university.getUsername(); // uni specified by course
        String authenticatedUniversity = SecurityContextHolder.getContext().getAuthentication().getName(); // uni authed
        if (courseDao.existsByCourseName(course.getCourseName())
                && authenticatedUniversity.equals(universityFromDAO)) {
            return false;
        } else {
            courseDao.save(course);
            return true;
        }
    }

    /**
     * Deletes a course
     * The uni specified by course must be authenticated
     * Removes course from course dao
     * @return true if did delete
     */
    public boolean deleteCourse(int courseId) {
        Course course = courseDao.findById(courseId).get(); // find registered course
//        University university = (University) userDao.findById(course.getUniversityId()).get();
//        String universityFromDAO = university.getUsername(); // uni specified by course
//        String authenticatedUniversity = SecurityContextHolder.getContext().getAuthentication().getName(); // uni authed
        if (courseDao.existsByCourseName(course.getCourseName())
               /* && authenticatedUniversity.equals(universityFromDAO)*/) {
            courseDao.delete(course);
            return true;
        } else {
            return false;
        }
    }

    public UniversityPublicInfo getUniversityForCourse(int courseId) {
        University university = (University) userDao.findById(courseDao.findByCourseId(courseId).get().getUniversityId()).get();
        return new UniversityPublicInfo(university.getUsername(), university.getUserId());
    }
}
