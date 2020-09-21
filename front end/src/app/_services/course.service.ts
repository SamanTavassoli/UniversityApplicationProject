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

  constructor(private http: HttpClient) { }

  getCourse(courseId: number) {
    return this.http.get<Course>(COURSE_API + '/' + courseId.toString)
  }

  // testUni = new University('test uni')
  // testCourses = [
  //   new Course(1, this.testUni, 'course1', 1, 1, 1),
  //   new Course(1, this.testUni, 'course2', 1, 1, 1),
  //   new Course(1, this.testUni, 'course2', 1, 1, 1)]
  courses: Course[]

  getAllCourses() {
    if (!sessionStorage.getItem('testCourses')) {  // fetch from server if sessionStorage doesn't contain data
      this.http.get<[Course]>(COURSE_API + '/allCourses')
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


}
