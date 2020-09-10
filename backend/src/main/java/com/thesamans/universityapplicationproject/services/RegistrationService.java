package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    UserDao userDao;

    /** Admin service for ease of use */
    public <T extends User> T addUser(T user) {
        if (userDao.existsByUsername(user.getUsername())) {
            return null;
        } else {
            return userDao.save(user);
        }
    }

    /** Registering student to student database
     *  Will register the student if they do not already exist
     *
     * @param user Student to be added
     * @return true if student could be added
     */
    public <T extends User> Boolean registerUser(T user) {
        if (userDao.existsByUsername(user.getUsername())) {
            return false;
        } else {
            userDao.save(user);
            return true;
        }
    }
}
