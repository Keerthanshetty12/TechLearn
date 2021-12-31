import { TestBed } from '@angular/core/testing';
import { UserAssessmentService } from './user-assessment.service';

describe('UserAssessmentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserAssessmentService = TestBed.get(UserAssessmentService);
    expect(service).toBeTruthy();
  });
});
