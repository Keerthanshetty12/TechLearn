import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivityUpdateComponent } from './activity-update.component';

describe('ActivityUpdateComponent', () => {
  let component: ActivityUpdateComponent;
  let fixture: ComponentFixture<ActivityUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActivityUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActivityUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
