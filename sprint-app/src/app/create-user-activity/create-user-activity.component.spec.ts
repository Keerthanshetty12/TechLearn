import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateUserActivityComponent } from './create-user-activity.component';

describe('CreateUserActivityComponent', () => {
  let component: CreateUserActivityComponent;
  let fixture: ComponentFixture<CreateUserActivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateUserActivityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateUserActivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
