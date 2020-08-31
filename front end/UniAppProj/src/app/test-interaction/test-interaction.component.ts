import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-test-interaction',
  templateUrl: './test-interaction.component.html',
  styleUrls: ['./test-interaction.component.css']
})
export class TestInteractionComponent implements OnInit {

  constructor(private http: HttpClient) {

   }

  ngOnInit(): void {
    let obs = this.http.get('http://localhost:8080/user')
    obs.subscribe((response) => console.log(response));
    
  }



}
