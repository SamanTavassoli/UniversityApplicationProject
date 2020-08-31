package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Generic class to handle students, universities and admins
 * Handles the appropriate level of detail to be added and retrieved to the userDao based on the type of user
 */
@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public <T extends User> T addUser(T user) {
        return userDao.save(user);
    }

    public <T extends User> T getUser(int userId) {
        Optional<User> user = userDao.findById(userId);

        if (user.isEmpty()) {
            System.err.println("No such user");
            return null;
        }

        return (T) user.get();
    }

    // todo: implement getter that returns all students from userDao

    // todo: implement getter that returns all universities from userDao

    public List<User> getUserList() {
        return userDao.findAll();
    }

    public void deleteUser(int userId) {
        userDao.deleteById(userId);
    }

}
