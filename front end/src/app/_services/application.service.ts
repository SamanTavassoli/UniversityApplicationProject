import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthenticationService } from './user-authentication.service';
import { Application } from '../_models/application';

const APPLICATION_API = 'http://localhost:8080/application'

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(
    private http: HttpClient,
    private authService: UserAuthenticationService
    ) { }

  sendApplications(coursesToSend) {
    return this.http.post<boolean>(APPLICATION_API + '/student/sendApplications/' + this.authService.userValue.userId, coursesToSend)
  }

  getApplicationsForCourse(courseId) {
    return this.http.get<Application[]>(APPLICATION_API + '/uni/getApplicationsForCourse/' + courseId);
  }
}
