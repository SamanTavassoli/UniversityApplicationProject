import { ApplicationStatus } from "./application-status";

/**
 * Contains fields required for a user to make an application to a course
 */
export class Application {
    applicationId: number;
    userId: number;
    courseId: number;
    dateOfApplication: Date;
    dateOfReview: Date;
    dateOfDecision: Date;
    applicationStatus: ApplicationStatus;
}