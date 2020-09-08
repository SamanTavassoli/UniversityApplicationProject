package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.model.users.UserType;
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

    /**
     * Looks for a specific user in database
     * @param userId User Id for the user requested
     * @param <T> Type of user requested
     * @return returns the casted user object if the retrieved user is of specified type, otherwise null
     */
    public <T extends User> T getUser(UserType userType, int userId) {
        Optional<User> user = userDao.findById(userId);

        if (user.isEmpty()) {
            System.err.println("No such user");
            return null;
        }

        // check if retrieved class is specified class
        // wasn't gonna spend forever finding the method that gives just the class cause I'm getting:
        // com.thesamans.universityapplicationproject.model.users.Admin
        // just getting the last string after the last dot
        String fullClassName = user.get().getClass().getName();
        String classToCaps = fullClassName.substring(fullClassName.lastIndexOf(".") + 1).toUpperCase();
        if (classToCaps.equals(userType.name())) {
            return (T) user.get();
        } else {
            return null;
        }

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
