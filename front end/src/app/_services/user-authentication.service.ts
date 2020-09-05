import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../_models/user';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {

  restBaseUrl = 'http://localhost:8080';

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  /**
   * When the service is called it automatically looks for the currentUser in local storage
   * to check if the user is already logged in
   */
  constructor(private http: HttpClient) { 
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')))
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
}

/**
 * Log the user in by making a rest call and getting a user json back
 * Store user json with the jwt token in local storage to keep user logged in
 * 
 * If the post gets a user back then it also has a token
 * If the authentication fails then get null reply
 */
  login(username: string, password: string) {
    let params = new HttpParams()
      .set('username', username)
      .set('password', password)

    return this.http.post<User>(this.restBaseUrl + '/user/login', {params})
    .pipe(map(user => {
      localStorage.setItem('currentUser', JSON.stringify(user))
      this.currentUserSubject.next(user)
      return user;
    }));
  }

  /**
   * Log out by removing user json which has the jwt token from local storage
   */
  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

  register(username: string, password: string) {
    let params = new HttpParams()
      .set('username', username)
      .set('password', password)

    return this.http.post(this.restBaseUrl + '/user/register', {params})
  }
}
