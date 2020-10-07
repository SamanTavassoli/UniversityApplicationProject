import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { ApplicationService } from '../_services/application.service';
import { UserService } from '../_services/user.service';

/**
 * Course page contains details about the course that any user can see
 * 
 * Students specifically can chose to apply if they haven't already by adding this course
 * to their list of considered courses first
 */
@Component({
  selector: 'app-course-page',
  templateUrl: './course-page.component.html',
  styleUrls: ['./course-page.component.css']
})
export class CoursePageComponent implements OnInit {

  disableAddConsidered = true
  course = new Course(0,'',0,0,0);
  isStudent = false;
  isConsidered = false;
  
  
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private courseService: CourseService,
    private authService: UserAuthenticationService,
    private userService: UserService,
    private applicationService: ApplicationService) { 
      this.studentHasAppliedToCourse()
  }

  ngOnInit(): void {
    this.isStudent = !(this.authService.userValue === null) && this.authService.userValue.userType === 'Student';

    // fetch the course details given the course Id provided in the query params
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

      this.studentHasAppliedToCourse()
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

  /**
   * If a student has already applied to this course, he can't add the course to his list of considered courses
   */
  studentHasAppliedToCourse() {
    
    this.applicationService.getApplicationsForStudent().subscribe( applications => {
      var hasApplied = false
      for (let application of applications) {
        if (application.courseId === this.course.courseId) {
          hasApplied = true
        }
      }

      this.disableAddConsidered = hasApplied
      return
    })
    
    this.disableAddConsidered = true // if http request fails, default doesn't allow student to add to considered
  }

}
