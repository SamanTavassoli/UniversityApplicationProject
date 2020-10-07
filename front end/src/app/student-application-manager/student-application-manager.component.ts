import { Component, OnInit } from '@angular/core';
import { Course } from '../_models/course';
import { ApplicationService } from '../_services/application.service';
import { CourseService } from '../_services/course.service';
import { UserService } from '../_services/user.service';

/**
 * Manages applications to different courses for a student
 * 
 * Handles how to display considered courses and applied to courses
 * The student can interact with this component to change consideration preferences or withdraw from an application
 */
@Component({
  selector: 'app-student-application-manager',
  templateUrl: './student-application-manager.component.html',
  styleUrls: ['./student-application-manager.component.css']
})
export class StudentApplicationManagerComponent implements OnInit {

  /** does user want to see their applications? */
  applicationsShown = false;
  /** applications that have already been sent */
  applicationsSent = []
  /** courses tied to the applications that have been sent indexed corresponding to applications sent */
  coursesForApplications = []
  /** universities tied to the applications that have been sent indexed corresponding to applications sent */
  universitiesForApplications = []

  coursesConsidered = []
  /** The user can select courses from the ones they are considering and chose to apply with those ones */
  coursesSelected = []; // holds boolean values for which courses in coursesConsidered have been selected

  constructor(private userService: UserService, private courseService: CourseService, private applicationService: ApplicationService) {
  }

  ngOnInit(): void {
    // getting considered courses from back end
    this.userService.getConsideredCourses().subscribe(courses => {
      this.coursesConsidered = []
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

    this.reloadApplications()
  }

  // ------- Course selection

  chose(course) {
    this.coursesSelected[this.coursesConsidered.indexOf(course)] = true;
  }

  unchose(course) {
    this.coursesSelected[this.coursesConsidered.indexOf(course)] = false;
  }

  didChose(course) {
    return this.coursesSelected[this.coursesConsidered.indexOf(course)];
  }

  // ------- Application methods
  
  // checks that at most 5 courses are selected in the coursesSelected boolean array
  sendApplication() {
    var coursesToSend = [];
    for (let pick in this.coursesSelected) {
      if (this.coursesSelected[pick] == true) {
        coursesToSend.push(this.coursesConsidered[pick].courseId)
      }
    }

    if (coursesToSend.length > 5 || coursesToSend.length == 0) {
      window.alert('You must choose between 1 and 5 courses')
      return
    }

    this.applicationService.sendApplications(coursesToSend).subscribe(response => {
      if (response == false) {
        window.alert('Applications did not go through successfully')
      } else {

        for (let courseId of coursesToSend) {
          this.removeFromConsideredCoursesWhenApplying(courseId)
        }

        this.reloadApplications()

        this.applicationsShown = true;
      }
    })   
    
  }

  viewApplications() {
    this.applicationsShown = true;
  }

  hideApplications() {
    this.applicationsShown = false;
  }

  deleteApplication(appId) {
    this.applicationService.deleteApplication(appId).subscribe(didDelete => {
      if (!didDelete) {
        window.alert('couldn\'t withdraw application')
      } else {
        this.ngOnInit()
      }
    })
  }

  /**
   * Get updated list of applications from back end
   * Reset the corresponding lists of courses and universities
   */
  reloadApplications() {
    this.applicationService.getApplicationsForStudent().subscribe( applications => {
      this.applicationsSent = applications

      this.coursesForApplications = []
      this.universitiesForApplications = []

      for (let application of applications) {
        this.addCourse(application.courseId)
        this.addUniversity(application.courseId)
      }
    })
  }

  removeFromConsideredCoursesWhenApplying(courseId) {
    this.userService.removeFromConsideredCourses(courseId).subscribe(success => {
      if (!success) {
        window.alert('Removing course from applications considered failed when sending applications')
      } else {
        this.coursesSelected.splice(this.coursesSelected.indexOf(courseId), 1)
        this.coursesConsidered.splice(this.coursesConsidered.indexOf(courseId), 1)
      }});
  }

  // --------- fetching courses and universities from back end for display

  addCourse(courseId): Course {
    this.courseService.getCourse(courseId).subscribe(course => {
      this.coursesForApplications.push(course)
    })
    return
  }

  getCourseNameForApplication(application) {
    return this.coursesForApplications[this.applicationsSent.indexOf(application)].courseName
  }

  addUniversity(courseId) {
    this.courseService.getUniversityForCourse(courseId).subscribe(university => {
      this.universitiesForApplications.push(university);
    })
  }

  getUniversityNameForApplication(application) {
    return this.universitiesForApplications[this.applicationsSent.indexOf(application)].username
  }
}
