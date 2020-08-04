package com.thesamans.universityapplicationproject.services.users;

import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private UserDao userDao;

    public Student addStudent(Student student) {
        return userDao.save(student);
    }

    // todo: implement getter that returns all students from userDao

    // finds by userId not student id
    public Student getStudent(int userId) {
        Optional<User> student = userDao.findById(userId);

        if (student.isEmpty()) {
            System.err.println("No such student");
            return null;
        }
        return (Student) student.get();
    }

    // cannot delete a student, go through user to delete
}
