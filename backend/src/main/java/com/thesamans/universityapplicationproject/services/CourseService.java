package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.model.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    /**
     * Adds a course if not other course shares that course name
     */
    public boolean addCourse(Course course) {
        String authenticatedUniversity = SecurityContextHolder.getContext().getAuthentication().getName();
        String courseUniversity = course.getUniversity().getUsername(); // university tied to the course
        if (courseDao.existsByCourseName(course.getCourseName()) && authenticatedUniversity.equals(courseUniversity)) {
            return false;
        } else {
            courseDao.save(course);
            return true;
        }
    }
}
