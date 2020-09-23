import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthenticationService } from './user-authentication.service';

const APPLICATION_API = 'http://localhost:8080/application'

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(
    private http: HttpClient,
    private authService: UserAuthenticationService
    ) { }

  addToApplications(courseId: number) {
    return this.http.post<boolean>(APPLICATION_API + '/addToApplications/' + courseId, this.authService.userValue.userId)
  }
}
