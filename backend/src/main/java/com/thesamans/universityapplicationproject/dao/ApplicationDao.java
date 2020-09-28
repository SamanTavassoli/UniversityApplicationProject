package com.thesamans.universityapplicationproject.dao;

import com.thesamans.universityapplicationproject.model.application.Application;
import com.thesamans.universityapplicationproject.model.course.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationDao extends CrudRepository<Application, Integer> {

    @Override
    List<Application> findAll();

    Optional<Application> findByApplicationId(int applicationId);

    List<Optional<Application>> findByUserId(int userId);
}
