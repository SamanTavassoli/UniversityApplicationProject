import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestInteractionComponent } from './test-interaction.component';

describe('TestInteractionComponent', () => {
  let component: TestInteractionComponent;
  let fixture: ComponentFixture<TestInteractionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestInteractionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestInteractionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
