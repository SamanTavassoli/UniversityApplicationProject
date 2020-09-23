import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { ApplicationService } from '../_services/application.service';

@Component({
  selector: 'app-course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  course: Course;
  isStudent: boolean;
  
  
  constructor(
    private route: ActivatedRoute,
    private _location: Location,
    private courseService: CourseService,
    private authService: UserAuthenticationService,
    private applicationService: ApplicationService) { 

  }

  ngOnInit(): void {
    this.route.queryParams
    .subscribe( params => {
      this.courseService.getCourse(params.courseId).subscribe( course =>
        this.course = course);
    })

    this.isStudent = this.authService.userValue.userType === 'Student'

  }

  back() {
    this._location.back();
  }

  addToApplications() {
    this.applicationService.addToApplications(this.course.courseId).subscribe( success => {
      if (success) {
        
      } else {
        window.alert('Adding to applications failed')
      }
    });
  }

}
