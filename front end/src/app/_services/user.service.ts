import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { University } from '../_models/university';

const TEST_API = 'http://localhost:8080/user'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // only student accounts should be able to retrieve this
  testStudent() {
    return this.http.get<[string]>(TEST_API + '/student/test');
  }

  // only uni accounts should be able to retrieve this
  testUni() {
    return this.http.get<string>(TEST_API + '/university/test');
  }

}
