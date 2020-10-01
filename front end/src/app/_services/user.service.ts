import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsernameForStudentResponse } from '../university-course-manager-course-view/university-course-manager-course-view.component';
import { Course } from '../_models/course';
import { University } from '../_models/university';
import { UserAuthenticationService } from './user-authentication.service';
import { UniversityPublicInfo } from '../_models/university-public-info';

const USER_API = 'http://localhost:8080/user'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private authService: UserAuthenticationService) { }

  getConsideredCourses() {
    return this.http.get<number[]>(USER_API + '/student/getConsideredCourses/' + this.authService.userValue.userId)
  }

  addToConsideredCourses(courseId: number) {
    return this.http.post<boolean>(USER_API + '/student/addToConsideredCourses/' + courseId + '/' + this.authService.userValue.userId, {})
  }

  removeFromConsideredCourses(courseId: number) {
    return this.http.post<boolean>(USER_API + '/student/removeFromConsideredCourses/' + courseId + '/' + this.authService.userValue.userId, {})
  }

  isConsideredCourse(courseId: number) {
    return this.http.get<boolean>(USER_API + '/student/isConsideredCourse/' + courseId + '/' + this.authService.userValue.userId)
  }

  getStudentUsername(studentId: number) {
    return this.http.get<UsernameForStudentResponse>(USER_API + '/university/usernameForStudent/' + studentId)
  }

  getAllUniversityPublicInfo() {
    return this.http.get<UniversityPublicInfo[]>(USER_API + '/university/allPublicInfo/')
  }

  getUniversityPublicInfo(universityId: number) {
    return this.http.get<UniversityPublicInfo>(USER_API + '/university/publicInfo/' + universityId)
  }

}
