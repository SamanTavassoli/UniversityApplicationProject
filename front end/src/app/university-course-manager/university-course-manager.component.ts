import { Component, OnInit } from '@angular/core';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service'
import { UserAuthenticationService } from '../_services/user-authentication.service';

@Component({
  selector: 'app-university-course-manager',
  templateUrl: './university-course-manager.component.html',
  styleUrls: ['./university-course-manager.component.css']
})
export class UniversityCourseManagerComponent implements OnInit {

  constructor(private authService: UserAuthenticationService, private courseService: CourseService) { }

  ngOnInit(): void {
  }

  addCourse(event) {
    const target = event.target
    const courseName = target.querySelector('#courseName').value
    const availableSlots = target.querySelector('#availableSlots').value
    const courseDuration = target.querySelector('#courseDuration').value
    const fees = target.querySelector('#fees').value

    const course = new Course(this.authService.userValue.userId, courseName, availableSlots, courseDuration, fees)

    this.courseService.addCourse(course).subscribe(didAdd => {
      if (didAdd == true) {
        window.location.reload()
      } else {
        window.alert('Could not add course')
      }
    })
    
  }

}
