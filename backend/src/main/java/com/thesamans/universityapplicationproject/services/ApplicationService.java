package com.thesamans.universityapplicationproject.services;

import com.thesamans.universityapplicationproject.dao.CourseDao;
import com.thesamans.universityapplicationproject.dao.UserDao;
import com.thesamans.universityapplicationproject.model.application.Application;
import com.thesamans.universityapplicationproject.model.application.ApplicationFactory;
import com.thesamans.universityapplicationproject.model.application.ApplicationManager;
import com.thesamans.universityapplicationproject.model.course.Course;
import com.thesamans.universityapplicationproject.model.users.Student;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApplicationService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ApplicationManager applicationManager;

    @Autowired
    ApplicationFactory applicationFactory;

    /**
     * Creates Application through application factory,
     * Sends Applications to courses through application manager
     * Sets the user's hasApplied status to true
     * @param userId user applying
     * @param courseIds course ids for courses that the user wants to apply to
     * @return true if all applications could go through
     */
    public boolean sendApplications(int userId, int[] courseIds) {

        ArrayList<Application> applications = new ArrayList<>();

        for (int courseId : courseIds) {
            if (!applicationFactory.applicationMeetsCriteria(userId, courseId)) {
                return false;
            }
            applications.add(applicationFactory.newApplication(userId, courseId));
        }

        // create all applications first to make sure they are all valid and then send them
        for (Application application : applications) {
            applicationManager.sendApplication(application);
        }

        // comment out the 3 lines below when testing
//        Student student = (Student) userDao.findById(userId).get();
//        student.setHasApplied(true);
//        userDao.save(student);
        return true;
    }

}
