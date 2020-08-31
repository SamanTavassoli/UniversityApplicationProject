import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PermanentHeaderComponent } from './permanent-header.component';

describe('PermanentHeaderComponent', () => {
  let component: PermanentHeaderComponent;
  let fixture: ComponentFixture<PermanentHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PermanentHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PermanentHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
