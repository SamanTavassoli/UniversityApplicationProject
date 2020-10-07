import { Course } from '../_models/course'

/**
 * Different than the university user,
 * this is used to display a university to users on the University's public page specifically
 */
export class University {
    
    /**
     * Just holds the courseIds
     * Ask coure service for actual courses
     */
    courses: [number]

    constructor(
        public name: string,
    ) {
    
    }
}