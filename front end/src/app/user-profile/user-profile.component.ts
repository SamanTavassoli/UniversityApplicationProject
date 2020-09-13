import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  message: string;

  constructor(private authService: UserAuthenticationService, private userService: UserService) { }

  ngOnInit(): void {
    if (this.getUserType() == 'Student') {
      this.getTestStudentMessage();
    } else if (this.getUserType() == 'University') {
      this.getTestUniversityMessage();
    }
  }

  getUserType() {
    return this.authService.userValue.userType;
  }

  getTestStudentMessage() {
    this.userService.testStudent().subscribe(message =>
      this.message = message[0])
  }

  getTestUniversityMessage() {
    this.userService.testUni().subscribe(message =>
      this.message = message)
  }


}
