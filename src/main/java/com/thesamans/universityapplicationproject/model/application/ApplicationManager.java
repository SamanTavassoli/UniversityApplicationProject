package com.thesamans.universityapplicationproject.model.application;

public class ApplicationManager {


    public ApplicationStatus changeStatus(Application application, ApplicationStatus status) {
        application.setApplicationStatus(status);
        return application.getApplicationStatus();
    }

    public boolean sendApplication(Application application) {
        return false;
    }


}
