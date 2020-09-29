import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { Location } from '@angular/common';
import { ApplicationService } from '../_services/application.service';
import { Application } from '../_models/application';

@Component({
  selector: 'app-university-course-manager-course-view',
  templateUrl: './university-course-manager-course-view.component.html',
  styleUrls: ['./university-course-manager-course-view.component.css']
})
export class UniversityCourseManagerCourseViewComponent implements OnInit {

  course: Course;
  applications: Application[];

  constructor(
    private route: ActivatedRoute, 
    private courseService: CourseService,
    private location: Location,
    private applicationService: ApplicationService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.courseService.getCourse(params.courseId).subscribe (course => {
        this.course = course;

        // get applications for the course
        
        this.applicationService.getApplicationsForUni().subscribe(applications => {
          this.applications = applications;
        }

        )
      });
    })
  }

  back() {
    this.location.back();
  }

}
