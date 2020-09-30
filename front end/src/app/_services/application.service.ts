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

  sendApplications(coursesToSend: number[]) {
    return this.http.post<boolean>(APPLICATION_API + '/student/sendApplications/' + this.authService.userValue.userId, coursesToSend)
  }

  getApplicationsForCourse(courseId: number) {
    return this.http.get<Application[]>(APPLICATION_API + '/uni/getApplicationsForCourse/' + courseId);
  }

  getApplication(applicationId: number) {
    return this.http.get<Application>(APPLICATION_API + '/uni/getApplicationForId/' + applicationId)
  }

  setApplicationToInReview(applicationId: number) {
    return this.http.post<boolean>(APPLICATION_API + '/uni/setApplicationToInReview/' + applicationId, {})
  }

  setApplicationDecisionMade(applicationId: number, accepted: boolean) {
    return this.http.post<boolean>(APPLICATION_API + '/uni/setApplicationDecisionMade/' + applicationId + '/' + accepted, {} )
  }

  resetApplication(applicationId: number) {
    return this.http.post(APPLICATION_API + '/uni/resetApplication/' + applicationId, {})
  }
}
