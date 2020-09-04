import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchTerm: string = '';
  results = ['TestCourse 1', 'TestCourse 2', 'TestCourse 3'];

  constructor() { }

  ngOnInit(): void {
  }

  search() {

  }

}
