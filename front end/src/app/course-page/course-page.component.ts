import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  courseName: String = 'No course provided';
  
  
  constructor(private route: ActivatedRoute, private _location: Location) { 

  }

  ngOnInit(): void {
    this.route.queryParams
    .subscribe( params => {
      this.courseName = params.courseName;
    })
  }

  back() {
    this._location.back();
  }

}
