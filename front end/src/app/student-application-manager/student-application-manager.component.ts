import { Component, OnInit } from '@angular/core';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-student-application-manager',
  templateUrl: './student-application-manager.component.html',
  styleUrls: ['./student-application-manager.component.css']
})
export class StudentApplicationManagerComponent implements OnInit {

  coursesConsidered: Course[];

  constructor(private userService: UserService, private courseService: CourseService) { }

  ngOnInit(): void {
    this.userService.getConsideredCourses().subscribe( courses => {
      this.coursesConsidered = [];
      for (let courseId of courses) {
        this.courseService.getCourse(courseId).subscribe( course => {
          this.coursesConsidered.push(course);
        })
      }
    })
  }


}
