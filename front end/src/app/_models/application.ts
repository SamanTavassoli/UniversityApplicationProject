import { ApplicationStatus } from "./application-status";

export class Application {
    applicationId: number;
    userId: number;
    courseId: number;
    dateOfApplication: Date;
    dateOfReview: Date;
    dateOfDecision: Date;
    applicationStatus: ApplicationStatus;
}