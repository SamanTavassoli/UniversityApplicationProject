import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UniversityCourseManagerComponent } from './university-course-manager.component';

describe('UniversityCourseManagerComponent', () => {
  let component: UniversityCourseManagerComponent;
  let fixture: ComponentFixture<UniversityCourseManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UniversityCourseManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UniversityCourseManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
