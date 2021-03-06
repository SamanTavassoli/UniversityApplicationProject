import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

import { Course } from '../_models/course'
import { University } from '../_models/university';
import { UniversityPublicInfo } from '../_models/university-public-info';

const COURSE_API = 'http://localhost:8080/courses'

/**
 * Contains the calls to the backend to handle information about courses
 */
@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  getCourse(courseId: number) {
    return this.http.get<Course>(COURSE_API + '/public/singleCourse/' + courseId);
  }

  getAllCoursesForUni(universityId: number) {
    return this.http.get<Course[]>(COURSE_API + '/public/allCoursesForUni/' + universityId);
  }

  getUniversityForCourse(courseId: number) {
    return this.http.get<UniversityPublicInfo>(COURSE_API + '/public/uniForCourse/' + courseId);
  }

  /** Get all the courses for all universities */
  getAllCourses() {
    return this.http.get<Course[]>(COURSE_API + '/public/allCourses');
  }

  addCourse(course: Course) {
    return this.http.post<boolean>(COURSE_API + '/add', course);
  }

  deleteCourse(courseId: number) {
    return this.http.delete<boolean>(COURSE_API + '/delete/' + courseId);
  }


}
