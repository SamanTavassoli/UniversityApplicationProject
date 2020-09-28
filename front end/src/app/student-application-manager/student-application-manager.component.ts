import { Component, OnInit } from '@angular/core';
import { Course } from '../_models/course';
import { ApplicationService } from '../_services/application.service';
import { CourseService } from '../_services/course.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-student-application-manager',
  templateUrl: './student-application-manager.component.html',
  styleUrls: ['./student-application-manager.component.css']
})
export class StudentApplicationManagerComponent implements OnInit {

  coursesConsidered: Course[];
  coursesSelected: boolean[]; // holds boolean values for which courses in coursesConsidered have been selected

  constructor(private userService: UserService, private courseService: CourseService, private applicationService: ApplicationService) {
    this.userService.getConsideredCourses().subscribe( courses => {
      this.coursesConsidered = [];
      for (let courseId of courses) {
        this.courseService.getCourse(courseId).subscribe( course => {
          this.coursesConsidered.push(course);
        })
      }
      // starting off with no courses selected
      this.coursesSelected = new Array<boolean>(this.coursesConsidered.length)
      for (var course of this.coursesSelected) {
        course = false;
      }
    })
  }

  ngOnInit(): void {
  }

  chose(course) {
    this.coursesSelected[this.coursesConsidered.indexOf(course)] = true;
    console.log(this.coursesConsidered.indexOf(course))
    console.log(this.coursesSelected[this.coursesConsidered.indexOf(course)])
  }

  unchose(course) {
    this.coursesSelected[this.coursesConsidered.indexOf(course)] = false;
  }

  didChose(course) {
    return this.coursesSelected[this.coursesConsidered.indexOf(course)];
  }

  // checks that at most 5 courses are selected in the coursesSelected boolean array

  sendApplication() {
    var coursesToSend = [];
    for (let pick in this.coursesSelected) {
      if (this.coursesSelected[pick] == true) {
        coursesToSend.push(this.coursesConsidered[pick])
      }
    }

    if (coursesToSend.length > 5 || coursesToSend.length == 0) {
      window.alert('You must choose between 1 and 5 courses')
      return
    }

    this.applicationService.sendApplications(coursesToSend).subscribe(response => {
      if (response == false) {
        window.alert('Applications did not go through successfully')
      }
    })    
  }

}
