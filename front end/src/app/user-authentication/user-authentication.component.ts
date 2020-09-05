import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from '../_services/user-authentication.service';

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


  constructor(private Auth: UserAuthenticationService) { }

  ngOnInit(): void {

  }

  login(event) {
    const target = event.target
    const username = target.querySelector('#username').value
    const password = target.querySelector('#password').value

    this.Auth.login(username, password);
    
  }

  register(event) {

  }

}
