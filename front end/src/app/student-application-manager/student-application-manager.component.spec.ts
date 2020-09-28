import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentApplicationManagerComponent } from './student-application-manager.component';

describe('StudentApplicationManagerComponent', () => {
  let component: StudentApplicationManagerComponent;
  let fixture: ComponentFixture<StudentApplicationManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentApplicationManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentApplicationManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
