package com.thesamans.universityapplicationproject.services.users;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.University;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniversityService {

    @Autowired
    private UserDao userDao;

    public University addUniversity(University university) {
        return userDao.save(university);
    }

    // todo: implement getter that returns all universities from userDao

    // finds by userId not student id
    public University getUniversity(int userId) {
        Optional<User> university = userDao.findById(userId);

        if (university.isEmpty()) {
            System.err.println("No such university");
            return null;
        }
        return (University) university.get();
    }

    // cannot delete a university, go through user to delete
}
