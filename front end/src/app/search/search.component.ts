import { ChangeDetectorRef, Component, OnChanges, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';

import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { UserService } from '../_services/user.service';
import { UniversityPublicInfo } from '../_models/university-public-info';

enum SearchType {
  Course,
  University,
}

/**
 * Allows the user to view courses and universities available and sort through them to pick the right one
 */
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{

  SearchType = SearchType;

  searchType: SearchType = SearchType.Course;
  searchTerm: string = '';
  courses: Course[] = [];
  universities: UniversityPublicInfo[] = [];

  constructor(private courseService: CourseService, private userService: UserService) { 

  }

  ngOnInit(): void {
    this.courseService.getAllCourses().subscribe( allCourses => {
      this.courses = allCourses
    });

    this.userService.getAllUniversityPublicInfo().subscribe( allPublicInfo => {
      this.universities = allPublicInfo;
    })
  }

  search() {
  }
}
