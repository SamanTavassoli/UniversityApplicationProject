import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UniversityCourseManagerApplicationViewComponent } from './university-course-manager-application-view.component';

describe('UniversityCourseManagerApplicationViewComponent', () => {
  let component: UniversityCourseManagerApplicationViewComponent;
  let fixture: ComponentFixture<UniversityCourseManagerApplicationViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UniversityCourseManagerApplicationViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UniversityCourseManagerApplicationViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
