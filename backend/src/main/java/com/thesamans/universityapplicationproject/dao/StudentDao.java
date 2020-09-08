package com.thesamans.universityapplicationproject.dao;

import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This repository holds the data for all Students
 */
@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

    @Override
    List<Student> findAll();

    Optional<Student> findByUsername(String username);

    Boolean existsByName(String name);
}
