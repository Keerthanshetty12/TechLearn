import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Assessment } from '../model/assessment';
import { User } from '../model/user';
import { UserAssessment } from '../model/userAssessment';
import { ActivityService } from '../service/activity.service';
import { AssessmentService } from '../service/assessment.service';
import { UserAssessmentService } from '../service/user-assessment.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-create-user-assessment',
  templateUrl: './create-user-assessment.component.html',
  styleUrls: ['./create-user-assessment.component.css']
})
export class CreateUserAssessmentComponent implements OnInit {
 
  constructor(private service: UserAssessmentService,private userservice:UserService,
    private assessmentservice:AssessmentService, private router:Router) { }

    message: string = null;
    validationMessages:string[]=null;
    msgClass:string;
  assessments:Assessment[];
  users:User[];

  ngOnInit() {
    this.userservice.getAllUsers().subscribe(
      (data)=>this.users=data,
      )
      this.assessmentservice.getAll().subscribe(
        (data)=>this.assessments=data,
        )
  }
 
 
  saveData(data) {
    let user:User={userName:data.user,password:null,firstName:null,lastName:null,emailId:null,role:null};
   let assessment:Assessment={assessmentId:data.assessmentId,assessmentName:null,releaseDate:null,duration:null,type:null};
   let userassessment:UserAssessment={userAssessmentId:data.userAssessmentId,user:user,assessment:assessment,score:data.score,badge:data.badge};
  
    console.log(data);
    this.service.saveUserAssessment(userassessment).subscribe(
      (resp)=>{
       this.message = resp.message
       this.msgClass = 'alert alert-success'
       this.validationMessages=null;
      },
      (fail)=>{
        console.log(data);
       this.message = fail.error.errorMessage;
       this.validationMessages=fail.error.errors;
       this.msgClass = 'alert alert-danger'
  
      }
  
    )
   }
  
  gotoList() {
  this.router.navigate(["userAssessmentlist"])
  }
  
}
