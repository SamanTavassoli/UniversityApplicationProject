import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { UserService } from '../_services/user.service';

/**
 * Hosts information about a specific user's profile
 * Doesn't directly display profile, delegates to corresponding university/student components
 */
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  message: string;

  constructor(private authService: UserAuthenticationService, private userService: UserService) { }

  ngOnInit(): void {
  }

  getUserType() {
    return this.authService.userValue.userType;
  }

}
