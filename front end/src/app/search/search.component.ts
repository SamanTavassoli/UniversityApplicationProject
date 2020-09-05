import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';

enum SearchType {
  Course,
  University,
}

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  SearchType = SearchType;

  searchType: SearchType = SearchType.Course;
  searchTerm: string = '';
  courses = ['TestCourse 1', 'TestCourse 2', 'TestCourse 3'];
  universities = ['TestUni 1', 'TestUni 2', 'TestUni 3'];

  constructor() { }

  ngOnInit(): void {
  }

  search() {

  }

}
