import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UniversityCourseManagerCourseViewComponent } from './university-course-manager-course-view.component';

describe('UniversityCourseManagerCourseViewComponent', () => {
  let component: UniversityCourseManagerCourseViewComponent;
  let fixture: ComponentFixture<UniversityCourseManagerCourseViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UniversityCourseManagerCourseViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UniversityCourseManagerCourseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
