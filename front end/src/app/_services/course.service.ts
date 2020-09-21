import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

import { Course } from '../_models/course'
import { University } from '../_models/university';

const COURSE_API = 'http://localhost:8080/courses'

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  courses: Course[]

  constructor(private http: HttpClient) { }

  getCourse(courseId: number) {
    return this.http.get<Course>(COURSE_API + '/public/' + courseId)
  }

  getAllCoursesForUni(universityId: number) {
    return this.http.get<Course[]>(COURSE_API + '/public/allCoursesForUni/' + universityId)
  }

  /** Get all the courses for all universities */
  getAllCourses() {
    if (!sessionStorage.getItem('testCourses')) {  // fetch from server if sessionStorage doesn't contain data
      this.http.get<Course[]>(COURSE_API + '/public/allCourses')
      .subscribe(courses => {
        sessionStorage.setItem('courses', JSON.stringify(courses))
        this.courses = courses;
      })
      // this.courses = this.testCourses
      // sessionStorage.setItem('testCourses', JSON.stringify(this.testCourses))
    } else {
      this.courses = JSON.parse(sessionStorage.getItem('testCourses'))
    }
    return this.courses
  }

  addCourse(course: Course) {
    return this.http.post<boolean>(COURSE_API + '/add', course)
  }


}
