package com.thesamans.universityapplicationproject.dao;

import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();

    // tell to jpa: give me a method that finds a user by username
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

}
