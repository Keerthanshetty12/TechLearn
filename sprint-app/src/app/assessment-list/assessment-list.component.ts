import { Component, OnInit } from '@angular/core';
import { Assessment } from '../model/assessment';
import { AssessmentService } from '../service/assessment.service';

@Component({
  selector: 'app-assessment-list',
  templateUrl: './assessment-list.component.html',
  styleUrls: ['./assessment-list.component.css']
})
export class AssessmentListComponent implements OnInit {

  constructor(private service: AssessmentService) {}

  ngOnInit(): void {
    this.loadData();
  }

  assessment: Assessment[];

  message: string = null;

  delete(assessmentId: number) {
    this.service.deleteAssessment(assessmentId).subscribe(
      (resp) => {
        this.loadData();
        this.message = "succeessfully deleted";
      },
      (response) => {
        this.message=response.error.errorMessage;
      }
    );
    }
    loadData() {
      this.service.getAll().subscribe(
      (data)=> (this.assessment=data),
      (response)=> (this.message=response.error.errorMessage)
      );
      }

}
