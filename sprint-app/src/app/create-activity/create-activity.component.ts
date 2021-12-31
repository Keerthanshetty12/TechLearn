import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Activity } from '../model/activity';
import { ActivityService } from '../service/activity.service';

@Component({
  selector: 'app-create-activity',
  templateUrl: './create-activity.component.html',
  styleUrls: ['./create-activity.component.css']
})
export class CreateActivityComponent implements OnInit {

  
  constructor(private service: ActivityService, private router: Router) {}
  
  ngOnInit(): void {
  }

  success:boolean
  message: string = null;
  validationMessages: string[];
  errorMessage: string=null;
  msgClass:string;

  saveData(activity: Activity) {
    console.log(activity);
    this.service.saveActivity(activity).subscribe(
    
     (resp) =>{
      this.message = resp.message;
      this.msgClass = 'alert alert-success';
      this.validationMessages = null;
    },
    (fail)=> {
      console.log(activity)
      this.message = fail.error.errorMessage;
      this.validationMessages= fail.error.errors;
      this.msgClass= 'alert alert-danger';
    }
    );
  }
  gotoList(){
    this.router.navigate(["activitylist"])
  }
}
