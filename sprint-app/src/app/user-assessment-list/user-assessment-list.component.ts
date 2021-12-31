import { Component, OnInit } from '@angular/core';
import { UserAssessment } from '../model/userAssessment';
import { AssessmentService } from '../service/assessment.service';
import { UserAssessmentService } from '../service/user-assessment.service';
import { UserService } from '../service/user.service';


@Component({
  selector: 'app-user-assessment-list',
  templateUrl: './user-assessment-list.component.html',
  styleUrls: ['./user-assessment-list.component.css']
})
export class UserAssessmentListComponent implements OnInit {

  constructor(private service: UserAssessmentService,private userservice:UserService,
    private activityservice:AssessmentService) { }

  ngOnInit() {
    this.loadData();
  }
  userassessment: UserAssessment[];
  assessmentid:number[];
  userName:string[];
  message: string = null;

  loadData() {
    this.service.getAllUserAssessment().subscribe(
      (data) => (this.userassessment = data,console.log(data)),
      (response) => (this.message = response.error.errorMessage)
    );
  }
}
