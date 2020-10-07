import { Component, OnInit } from '@angular/core';

/**
 * Required class for routing
 * Profiles, authentication etc. follow this component
 */
export class User {
  userId: number;
  username: String;
  password: String;

  constructor(userId: number, username: String, password: String) {
    this.userId = userId;
    this.username = username;
    this.password = password;
  }

}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  

}
