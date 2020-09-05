import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-university-page',
  templateUrl: './university-page.component.html',
  styleUrls: ['./university-page.component.css']
})
export class UniversityPageComponent implements OnInit {

  universityName = 'No University Provided';
  
  constructor(private route: ActivatedRoute, private _location: Location) { 

  }

  ngOnInit(): void {
    this.route.queryParams
    .subscribe( params => {
      this.universityName = params.universityName;
    })
  }

  back() {
    this._location.back();
  }

}
