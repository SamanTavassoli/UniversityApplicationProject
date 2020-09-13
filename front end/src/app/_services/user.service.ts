import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const TEST_API_URL = 'http://localhost:8080/user'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // only student accounts should be able to retrieve this
  testStudent() {
    return this.http.get<[string]>(TEST_API_URL + '/student/test');
  }

  // only uni accounts should be able to retrieve this
  testUni() {
    return this.http.get<string>(TEST_API_URL + '/university/test');
  }

}
