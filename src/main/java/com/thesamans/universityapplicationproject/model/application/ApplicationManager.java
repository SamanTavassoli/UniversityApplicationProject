package com.thesamans.universityapplicationproject.model.application;

import com.thesamans.universityapplicationproject.model.objects.Course;
import com.thesamans.universityapplicationproject.model.users.Student;
import com.thesamans.universityapplicationproject.model.utils.Locator;

import java.util.Date;
import java.util.Objects;

public class ApplicationManager {


    public boolean sendApplication(Application application) {

        Student student = Locator.getStudent(application.getStudentId());
        Course course = Locator.getCourse(application.getCourseId());

        Objects.requireNonNull(student);
        Objects.requireNonNull(course);

        if (!ApplicationMeetsCriteria(application)) return false;

        Date applicationDate = new Date();
        application.setDateOfApplication(applicationDate);
        application.setApplicationStatus(ApplicationStatus.APPLIED);

        student.getApplicationsSent().add(application);
        course.getApplicationsReceived().add(application);

        return true;
    }

    /**
     * Called when a University has received the application and has declared that it is under review
     * @param application application that has been received
     */
    public void applicationInReview(Application application) {
        Date reviewDate = new Date();
        application.setApplicationStatus(ApplicationStatus.IN_REVIEW);
        application.setDateOfReview(reviewDate);

    }

    /**
     * Called when a University has made their decision on an application
     * @param application application on which decision has been made
     * @param applicationStatus Accepted or Rejected
     */
    public void applicationDecisionMade(Application application, ApplicationStatus applicationStatus) {
        Date decisionDate = new Date();
        application.setApplicationStatus(applicationStatus);
        application.setDateOfDecision(decisionDate);
    }

    private ApplicationStatus changeStatus(Application application, ApplicationStatus status) {
        application.setApplicationStatus(status);
        return application.getApplicationStatus();
    }

    /**
     * Checks that the minimum fields required for an applications are at least populated
     * @param application application being checked
     * @return true if the application conforms to checklist
     */
    private boolean ApplicationMeetsCriteria(Application application) {
        return false; // todo: implement when criteria for application are created
    }
}
