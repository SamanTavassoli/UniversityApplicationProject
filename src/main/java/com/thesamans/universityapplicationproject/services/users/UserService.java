package com.thesamans.universityapplicationproject.services.users;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    // cannot add user directly, user is an abstract class

    public List<User> getUserList() {
        return userDao.findAll();
    }

    public User getUser(int userId) {
        Optional<User> user = userDao.findById(userId);

        if (user.isEmpty()) {
            System.err.println("No such user");
            return null;
        }
        return user.get();
    }

    public void deleteUser(int userId) {
        userDao.deleteById(userId);
    }
}
