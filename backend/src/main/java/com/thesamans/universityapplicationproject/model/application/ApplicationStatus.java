package com.thesamans.universityapplicationproject.model.application;

/**
 * Determines at what stage the application is
 * The Universities have control over changing between APPLIED, IN_REVIEW and ACCEPTED/REJECTED,
 * the dates of the changes are recorded by the application manager
 */
public enum ApplicationStatus {
    STARTED,
    APPLIED,
    IN_REVIEW,
    ACCEPTED,
    REJECTED;
}
