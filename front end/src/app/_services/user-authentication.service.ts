import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {

  restBaseUrl = 'http://localhost:8080';
  response: any;

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    let params = new HttpParams()
      .set('username', username)
      .set('password', password)

    let obs = this.http
      .get(this.restBaseUrl + '/user/login', {params} )
      .subscribe((response) => this.response = response)
  }

  register(username: string, password: string) {
    let params = new HttpParams()
      .set('username', username)
      .set('password', password)

    let obs = this.http
      .get(this.restBaseUrl + '/user/register', {params})
      .subscribe((response) => this.response = response)
  }
}
