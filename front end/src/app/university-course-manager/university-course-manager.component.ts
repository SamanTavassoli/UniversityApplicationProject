import { Component, OnInit } from '@angular/core';
import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service'
import { UserAuthenticationService } from '../_services/user-authentication.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

/**
 * Allows the university to get an overview of all their different courses
 * The university has the option to add / remove courses here
 */
@Component({
  selector: 'app-university-course-manager',
  templateUrl: './university-course-manager.component.html',
  styleUrls: ['./university-course-manager.component.css']
})
export class UniversityCourseManagerComponent implements OnInit {

  courseAdditionForm: FormGroup;
  courseDeletionForm: FormGroup;

  courses: Course[]

  constructor(private authService: UserAuthenticationService, private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.getAllCoursesForUni(this.authService.userValue.userId).subscribe(
      courses => {
        this.courses = courses
      }
    )

    this.courseAdditionForm = new FormGroup({
      courseName: new FormControl(''),
      availableSlots: new FormControl(''),
      courseDuration: new FormControl(''),
      fees: new FormControl('')
    })

    this.courseDeletionForm = new FormGroup({
      courseId: new FormControl('')
    })
  }

  // --------- Course management

  addCourse() {
    const form = this.courseAdditionForm.value;
    const courseName = form.courseName;
    const availableSlots = form.availableSlots;
    const courseDuration = form.courseDuration;
    const fees = form.fees;

    const course = new Course(this.authService.userValue.userId, courseName, availableSlots, courseDuration, fees)

    this.courseService.addCourse(course).subscribe(didAdd => {
      if (didAdd == true) {
        window.location.reload()
      } else {
        window.alert('Could not add course')
      }
    })
  }

  deleteCourse() {
    const form = this.courseDeletionForm.value;
    const courseId = form.courseId

    if (courseId == '') {
      window.alert('Must provide course to delete')
      return
    }
    this.courseService.deleteCourse(courseId).subscribe(didRemove => {
      if (didRemove == true) {
        window.location.reload()
      } else {
        window.alert('Could no delete course')
      }
    })
  }

}
