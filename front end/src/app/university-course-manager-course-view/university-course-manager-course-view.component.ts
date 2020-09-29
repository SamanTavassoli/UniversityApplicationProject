import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { Location } from '@angular/common';
import { ApplicationService } from '../_services/application.service';
import { Application } from '../_models/application';
import { UserService } from '../_services/user.service';

/**
 * Class's only purpose is to receive username response from backend
 */
export class UsernameForStudentResponse {
  username: string;
}

@Component({
  selector: 'app-university-course-manager-course-view',
  templateUrl: './university-course-manager-course-view.component.html',
  styleUrls: ['./university-course-manager-course-view.component.css']
})
export class UniversityCourseManagerCourseViewComponent implements OnInit {

  course: Course;
  applications: Application[];
  studentNames: string[];

  constructor(
    private route: ActivatedRoute, 
    private courseService: CourseService,
    private location: Location,
    private applicationService: ApplicationService,
    private userService: UserService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.courseService.getCourse(params.courseId).subscribe (course => {
        this.course = course;

        // get applications for the course
        
        this.applicationService.getApplicationsForCourse(this.course.courseId).subscribe(applications => {
          this.applications = applications;
          this.studentNames = []
          for (let application of applications) {
            this.userService.getStudentUsername(application.userId).subscribe(response => {
              this.studentNames.push((response).username)
            })
          }
        }
        )
      });
    })
  }

  getUsername(application: Application) {
    return this.studentNames[this.applications.indexOf(application)];
  }

  back() {
    this.location.back();
  }

}
