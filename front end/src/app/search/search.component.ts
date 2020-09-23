import { ChangeDetectorRef, Component, OnChanges, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';

import { Course } from '../_models/course';
import { CourseService } from '../_services/course.service';
import { UserService } from '../_services/user.service';

enum SearchType {
  Course,
  University,
}

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
  universities = ['TestUni 1', 'TestUni 2', 'TestUni 3'];

  constructor(private courseService: CourseService) { 
    this.courses = this.courseService.getAllCourses();
  }

  ngOnInit(): void {
    this.courses = this.courseService.getAllCourses();
  }

  search() {
  }
}
