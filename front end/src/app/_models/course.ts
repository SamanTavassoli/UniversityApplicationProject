import { University } from '../_models/university'

export class Course {
    constructor( // can't
        public _courseId: number,
        public _university: University,
        public _courseName: string,
        public _availableSlots: number,
        public _courseDuration: number,
        public _fees: number) {
    }

    // get courseName(): string {
    //     return this._courseName;
    // }
    // get courseId(): number {
    //     return this._courseId;
    // }
    // get university(): University {
    //     return this._university;
    // }
    // get availableSlots(): number {
    //     return this._availableSlots;
    // }
    // get courseDuration(): number {
    //     return this._courseDuration;
    // }
    // get fees(): number {
    //     return this._fees;
    // }
}