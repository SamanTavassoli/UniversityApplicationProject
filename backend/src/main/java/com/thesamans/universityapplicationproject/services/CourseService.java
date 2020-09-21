package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    public Course getCourse(int courseId) {
        return courseDao.findById(courseId).get();
    }

    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    /**
     * Adds a course if not other course shares that course name
     */
    public boolean addCourse(Course course) {
        String authenticatedUniversity = SecurityContextHolder.getContext().getAuthentication().getName();
        String courseUniversity = userDao.findById(course.getUniversityId()).get().getUsername(); // university tied to the course
        if (courseDao.existsByCourseName(course.getCourseName()) && authenticatedUniversity.equals(courseUniversity)) {
            System.err.println("didn't add");
            return false;
        } else {
            System.err.println("added");
            courseDao.save(course);
            return true;
        }
    }
}
