import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateUserAssessmentComponent } from './create-user-assessment.component';

describe('CreateUserAssessmentComponent', () => {
  let component: CreateUserAssessmentComponent;
  let fixture: ComponentFixture<CreateUserAssessmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateUserAssessmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateUserAssessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
