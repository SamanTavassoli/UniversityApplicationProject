import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from '../_services/user-authentication.service';

/**
 * At the top of the application at all times
 * Provides a link back the the main page, login, and profile
 */
@Component({
  selector: 'app-permanent-header',
  templateUrl: './permanent-header.component.html',
  styleUrls: ['./permanent-header.component.css']
})
export class PermanentHeaderComponent implements OnInit {

  username = '';

  constructor(private authService: UserAuthenticationService) { 
  }

  loggedIn() {
    return this.authService.isLoggedIn();
  }

  ngOnInit(): void {
    if (this.loggedIn()) {
      this.username = this.authService.userValue.username;
    } else {
      this.username = 'profile';
    }
  }

  logout() {
    this.authService.logout();
  }

}
