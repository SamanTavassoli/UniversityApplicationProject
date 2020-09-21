package com.thesamans.universityapplicationproject.dao;

import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao extends CrudRepository<Course, Integer> {

    @Override
    List<Course> findAll();

    Boolean existsByCourseName(String courseName);
}
