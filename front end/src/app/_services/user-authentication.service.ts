import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LoggedInUser } from '../_models/logged-in-user';
import { RegistrationUser } from '../_models/registration-user';
import { LoginRequestUser } from '../_models/login-request-user';

const AUTH_API = 'http://localhost:8080/auth'

/**
 * Contains the calls to the backend to handle information about authentication
 * 
 * Also allows the app to know at any point in time if the user is logged in or not
 */
@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {

  private userSubject: BehaviorSubject<LoggedInUser>;
  public user: Observable<LoggedInUser>;

  /**
   * When the service is called it automatically looks for the user in local storage
   * to check if the user is already logged in
   */
  constructor(private http: HttpClient) { 
    this.userSubject = new BehaviorSubject<LoggedInUser>(JSON.parse(localStorage.getItem('user')))
    this.user = this.userSubject.asObservable();
  }

  public get userValue(): LoggedInUser {
    return this.userSubject.value;
  }

  isLoggedIn() {
    return (this.userValue != null);
  }

/**
 * Log the user in by making a rest call and getting a user json back
 * Store user json with the jwt token in local storage to keep user logged in
 * 
 * If the post gets a user back then it also has a token
 * If the authentication fails then get null reply
 */
  login(username: string, password: string) {

    const loginRequestUser: LoginRequestUser = new LoginRequestUser(username, password);

    return this.http.post<LoggedInUser>(AUTH_API + '/login', loginRequestUser)
    .pipe(map(user => {
      // local storage item current user is how we know we are logged in
      // local storage persists so logged in until jwt expires or logout
      localStorage.setItem('user', JSON.stringify(user))
      this.userSubject.next(user)
      return user;
    }));
  }

  /**
   * Log out by removing user json which has the jwt token from local storage
   */
  logout() {
    localStorage.removeItem('user');
    this.userSubject.next(null);
  }

  /**
   * Send registration request to API
   * @param registrationUser must provide valid registrationUser instance
   * Returns true if user was succesfully registered
   */
  register(registrationUser: RegistrationUser) {

    return this.http.post<boolean>(AUTH_API + '/register', registrationUser)
  }
}
