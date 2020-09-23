import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { University } from '../_models/university';
import { UserAuthenticationService } from './user-authentication.service';

const USER_API = 'http://localhost:8080/user'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private authService: UserAuthenticationService) { }

  // only student accounts should be able to retrieve this
  testStudent() {
    return this.http.get<[string]>(USER_API + '/student/test');
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

  // only uni accounts should be able to retrieve this
  testUni() {
    return this.http.get<string>(USER_API + '/university/test');
  }

}
