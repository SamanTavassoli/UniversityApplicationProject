import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from '../_services/user-authentication.service';

@Component({
  selector: 'app-permanent-header',
  templateUrl: './permanent-header.component.html',
  styleUrls: ['./permanent-header.component.css']
})
export class PermanentHeaderComponent implements OnInit {

  constructor(private authService: UserAuthenticationService) { 
  }

  loggedIn() {
    return this.authService.isLoggedIn();
  }

  ngOnInit(): void {

  }

  logout() {
    this.authService.logout();
  }

}
