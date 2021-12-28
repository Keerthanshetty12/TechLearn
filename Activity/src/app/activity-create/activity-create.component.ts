import { Component, EventEmitter, Input, OnInit, Output, } from "@angular/core";
import { Router } from "@angular/router";
import { Activity } from "../model/activity";
import { ActivityService } from "../services/activity.service";

@Component({
  selector: "activity-create",
  templateUrl: "./activity-create.component.html",
  styleUrls: ["./activity-create.component.css"],
})
export class ActivityCreateComponent {
  @Output() close = new EventEmitter();

  constructor(private service: ActivityService, private router: Router) {}

  success:boolean
  message: string = null;
  validationMessages: string[];
  errorMessage: string=null;
  msgClass:string;
  saveData(activity: Activity) {
    console.log(activity);
    this.service.saveActivity(activity).subscribe(
    
     (resp) =>{
      this.message = "Successfully saved";
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


