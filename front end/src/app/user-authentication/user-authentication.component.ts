import { ApplicationRef, Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { Router } from '@angular/router';
import { User } from '../user/user.component';
import { RegistrationUser } from '../_models/registration-user';
import { FormGroup, FormControl, Validators } from '@angular/forms';

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

  loginForm: FormGroup;
  registerForm: FormGroup;

  AuthentificationType = AuthentificationType;
  authentificationType: AuthentificationType = AuthentificationType.Login;

  UserType = UserType;
  userType: UserType = UserType.Student;


  constructor(private authService: UserAuthenticationService, private router: Router) { }

  ngOnInit(): void {

    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    })

    this.registerForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
      email: new FormControl('', [Validators.email]),
      dateOfBirth: new FormControl('00/00/0000'),
    })
    
  }

  /**
   * Calls authentication service
   * If data is received it means the authentication worked
   * Otherwise authentication failed
   */
  login() {
    const form = this.loginForm.value
    const username = form.username
    const password = form.password  


    this.authService.login(username, password).subscribe(data => {
      if (data['token']) {
        // if we are logged in we are redirected to our profile
        this.router.navigate(['user/profile'])
      } else {
        window.alert('Error with login')
      }
    });
  }

  /**
   * Register a particular User
   * 
   * Creates a RegistrationUser object containing all the required fields
   * 
   * @param event Contains the information about the user
   * @param userType Type of User to be registered
   */
  register(userType: UserType) {
    const form = this.registerForm.value
    const username = form.username
    const password = form.password  
    const email = form.email
    var dateOfBirth;
    if (userType == UserType.Student) {
      dateOfBirth = form.dateOfBirth
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
