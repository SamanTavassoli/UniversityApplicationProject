/**
 * This is the template for registering any user that must be sent to the back end
 */
export class RegistrationUser {

    constructor(
        private username: string, 
        private password: string, 
        private email: string, 
        private userType: string, 
        private dateOfBirth: string = null) {
    }
}