package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.StudentDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    /** Admin service for ease of use */
    public Student addStudent(Student student) {
        if (studentDao.existsByName(student.getUsername())) {
            return null;
        } else {
            return studentDao.save(student);
        }
    }

    /** Registering student to student database
     *  Will register the student if they do not already exist
     *
     * @param student Student to be added
     * @return true if student could be added
     */
    public Boolean registerStudent(Student student) {
        if (studentDao.existsByName(student.getUsername())) {
            return false;
        } else {
            studentDao.save(student);
            return true;
        }

    }

    /**
     * Returning a Student's data from requested studentId
     * @param studentId to find correct student
     * @return Student's data in database
     */
    public Student getStudent(int studentId) {
        Optional<Student> student = studentDao.findById(studentId);

        if (student.isEmpty()) {
            System.err.println("No student found for Id");
            return null;
        } else {
            return student.get();
        }
    }

}
