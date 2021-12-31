import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Assessment } from '../model/assessment';
import { AssessmentService } from '../service/assessment.service';

@Component({
  selector: 'app-create-assessment',
  templateUrl: './create-assessment.component.html',
  styleUrls: ['./create-assessment.component.css']
})
export class CreateAssessmentComponent implements OnInit {

  
  constructor(private service: AssessmentService,private router:Router) {}
  
  ngOnInit(): void {}

  success:boolean
  message: string = null;
  validationMessages: string[];
  errorMessage: string = null;
  msgClass:string;
  saveData(x: Assessment) {
    console.log(x);
    this.service.saveAssessment(x).subscribe(
  
    (resp) =>{
      this.message = "succeessfully saved"
     this.msgClass = 'alert alert-success'
     this.validationMessages=null;
    },
    (fail)=>{
      console.log(x);
     this.message = fail.error.errorMessage;
     this.validationMessages=fail.error.errors;
     this.msgClass = 'alert alert-danger'
    }
  );   
  }
 
  gotoList() {
    this.router.navigate(["assessmentlist"])
    }

}
