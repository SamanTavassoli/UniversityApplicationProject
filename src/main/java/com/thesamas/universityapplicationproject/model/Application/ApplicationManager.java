package com.thesamas.universityapplicationproject.model.Application;

public class ApplicationManager {


    public ApplicationStatus changeStatus(Application application, ApplicationStatus status) {
        application.setApplicationStatus(status);
        return application.getApplicationStatus();
    }


}
