import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { Router } from '@angular/router';
import { User } from '../user/user.component';
import { RegistrationUser } from '../_models/registration-user';

enum AuthentificationType {
  Login,
  Register,
}

enum UserType {
  Student,
  University,
}

@Component({
  selector: 'app-user-authentication',
  templateUrl: './user-authentication.component.html',
  styleUrls: ['./user-authentication.component.css']
})
export class UserAuthenticationComponent implements OnInit {

  AuthentificationType = AuthentificationType;
  authentificationType: AuthentificationType = AuthentificationType.Login;

  UserType = UserType;
  userType: UserType = UserType.Student;


  constructor(private authService: UserAuthenticationService, private router: Router) { }

  ngOnInit(): void {

  }

  /**
   * Calls authentication service
   * If data is received it means the authentication worked
   * Otherwise authentication failed
   */
  login(event) {
    const target = event.target
    const username = target.querySelector('#username').value
    const password = target.querySelector('#password').value

    this.authService.login(username, password).subscribe(data => {
      if (data['token']) {
        // if we are logged in we are redirected to our profile
        this.router.navigate(['user/profile'])
      } else {
        window.alert('Error with login')
      }
    });
  }

  logout(event) {
    this.authService.logout();
    this.router.navigate(['user/authentication'])
  }

  /**
   * Register a particular User
   * 
   * Creates a RegistrationUser object containing all the required fields
   * 
   * @param event Contains the information about the user
   * @param userType Type of User to be registered
   */
  register(event, userType: UserType) {
    const target = event.target
    const username = target.querySelector('#username').value
    const password = target.querySelector('#password').value
    const email = target.querySelector('#email').value
    var dateOfBirth;
    if (userType == UserType.Student) {
      dateOfBirth = target.querySelector('#dateOfBirth').value
    }

    var registrationUser = new RegistrationUser(username, password, email, UserType[userType.toString()], dateOfBirth)

    this.authService.register(registrationUser).subscribe(answer => {
      if (answer == true) {
        // if registered now user should login
        window.location.reload()
      } else {
        window.alert('Error with registration')
      }
    })
  
  }

}
