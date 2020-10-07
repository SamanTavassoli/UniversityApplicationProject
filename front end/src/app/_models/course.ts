import { University } from '../_models/university'

/**
 * Course owned by a university to which students can apply
 */
export class Course {
    
    /**
     * Instantiate new course
     * if existing provide courseId
     * if not existing (to actually create one) do not provide course Id
    */
    constructor(
        public universityId: number,
        public courseName: string,
        public availableSlots: number,
        public courseDuration: number,
        public fees: number,
        public courseId?: number // only use when course already exists (not when creating one)
        ) {}
}