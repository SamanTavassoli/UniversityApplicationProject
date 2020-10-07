import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
import { UserService } from '../_services/user.service';
import { UniversityPublicInfo } from '../_models/university-public-info';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';

/**
 * Public University page that can be seen by any user
 * Should be accessed through the search functionality
 */
@Component({
  selector: 'app-university-page',
  templateUrl: './university-page.component.html',
  styleUrls: ['./university-page.component.css']
})
export class UniversityPageComponent implements OnInit {

  universityPublicInfo = new UniversityPublicInfo();
  coursesShown = false;
  courses = [];
  
  constructor(
    private route: ActivatedRoute,
    private _location: Location,
    private userService: UserService,
    private courseService: CourseService
    ) { 

  }

  ngOnInit(): void {
    this.route.queryParams
    .subscribe( params => {
      this.userService.getUniversityPublicInfo(params.universityId).subscribe( publicInfo => {
        this.universityPublicInfo = publicInfo;
      })

      this.courseService.getAllCoursesForUni(params.universityId).subscribe(courses => {
        this.courses = courses;
      })
    })
  }

  back() {
    this._location.back();
  }

  showCourses() {
    this.coursesShown = true;
  }

  hideCourses() {
    this.coursesShown = false;
  }

}
