package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.MyUserDetails;
import com.thesamans.universityapplicationproject.model.users.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
     */
    public boolean addCourse(Course course) {
        String authenticatedUniversity = SecurityContextHolder.getContext().getAuthentication().getName();
        String courseUniversity = userDao.findById(course.getUniversityId()).get().getUsername(); // university tied to the course
        if (courseDao.existsByCourseName(course.getCourseName()) && authenticatedUniversity.equals(courseUniversity)) {
            return false;
        } else {
            courseDao.save(course);
            return true;
        }
    }
}
