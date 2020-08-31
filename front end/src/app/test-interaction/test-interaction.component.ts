import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-test-interaction',
  templateUrl: './test-interaction.component.html',
  styleUrls: ['./test-interaction.component.css']
})
export class TestInteractionComponent implements OnInit {

  userId = "";
  restBaseUrl = 'http://localhost:8080';
  responseType = "none";
  response: any;

  constructor(private http: HttpClient) {

   }

  ngOnInit(): void {  
  }

  searchUser() {
    let obs = this.http.get(this.restBaseUrl + '/user/' + this.userId);
    this.resetResponse();
    this.responseType = "user";
    obs.subscribe((response) => this.response = response);
  }

  searchUsers() {
    let obs = this.http.get(this.restBaseUrl + '/user');
    this.resetResponse();
    this.responseType = "users";
    obs.subscribe((response) => this.response = response);
  }

  resetResponse() {
    this.response = undefined;
  }



}
