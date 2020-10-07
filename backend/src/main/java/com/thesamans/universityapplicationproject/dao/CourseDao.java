package com.thesamans.universityapplicationproject.dao;

import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseDao extends CrudRepository<Course, Integer> {

    @Override
    List<Course> findAll();

    Optional<Course> findByCourseId(int courseId);

    Boolean existsByCourseName(String courseName);

    Boolean existsByCourseId(int courseId);
}
