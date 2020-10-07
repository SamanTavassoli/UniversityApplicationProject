/**
 * Class containing information about the currently logged in user that can be retreived throughout the application
 */
export class LoggedInUser {
    userId: number;
    username: string;
    userType: string;
    token: string;
    hasApplied: boolean
}