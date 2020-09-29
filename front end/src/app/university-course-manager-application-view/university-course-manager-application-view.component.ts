import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-university-course-manager-application-view',
  templateUrl: './university-course-manager-application-view.component.html',
  styleUrls: ['./university-course-manager-application-view.component.css']
})
export class UniversityCourseManagerApplicationViewComponent implements OnInit {

  constructor(private location: Location) { }

  ngOnInit(): void {
  }

  back() {
    this.location.back();
  }
}
