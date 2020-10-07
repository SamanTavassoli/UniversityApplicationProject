import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { ApplicationService } from '../_services/application.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  shouldEnable = false
  course = new Course(0,'',0,0,0);
  isStudent = false;
  isConsidered = false;
  
  
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private courseService: CourseService,
    private authService: UserAuthenticationService,
    private userService: UserService) { 
    this.isConsidered = false;
  }

  ngOnInit(): void {
    this.isStudent = !(this.authService.userValue === null) && this.authService.userValue.userType === 'Student';

    this.route.queryParams
    .subscribe( params => {
      this.courseService.getCourse(params.courseId).subscribe( course => {
        this.course = course


        if (this.isStudent) {
          // check if student is considering course,
          // must be done after query params gives the courseId
        this.userService.isConsideredCourse(this.course.courseId).subscribe(isConsidered => {
          this.isConsidered = isConsidered;
        })
        }
      })})
  }

  back() {
    this.location.back();
  }

  addToConsideredCourses() {
    this.userService.addToConsideredCourses(this.course.courseId).subscribe( success => {
      if (success) {
        this.ngOnInit();
      } else {
        window.alert('Adding to applications failed')      
      }});
  }

  removeFromConsideredCourses() {
    this.userService.removeFromConsideredCourses(this.course.courseId).subscribe(success => {
      if (success) {
        this.ngOnInit();
      } else {
        window.alert('Removing from applications failed')
      }});
  }

}
