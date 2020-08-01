package com.thesamans.universityapplicationproject.dao;

import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();

}
