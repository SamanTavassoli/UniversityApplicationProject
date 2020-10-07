package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.RegistrationUser;
import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.utils.RegistrationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides services related to user registration
 * Registration controller directly calls this service
 */
@Service
public class RegistrationService {

    @Autowired
    UserDao userDao;

    @Autowired
    RegistrationUtil registrationUtil;

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
     *  and if they have provided the correct details
     *
     * @param user Student to be added
     * @return true if student was added
     */
    public Boolean registerUser(RegistrationUser user) {
        if (!registrationUtil.canCreateUser(user)) {
            return false;
        } else {
            registrationUtil.createUser(user);
            return true;
        }
    }
}
