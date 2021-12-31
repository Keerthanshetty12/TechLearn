import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Activity } from '../model/activity';
import { ActivityService } from '../service/activity.service';

@Component({
  selector: 'app-activity-update',
  templateUrl: './activity-update.component.html',
  styleUrls: ['./activity-update.component.css']
})
export class ActivityUpdateComponent implements OnInit {

  constructor(private service: ActivityService,private route: ActivatedRoute, private router: Router) {}
  activity: Activity={activityId:null,activityName:"",startDate:null,endDate:null,duration:null}
  msgClass: string;
  message: string = null;
  failMessage: string = null;
  validationMessages:string[]=null;

  ngOnInit() {

    this.route.paramMap.subscribe(
      (params) => {
        let activityId:number = parseInt(params.get('activityId'))
      console.log(activityId);
        this.service.getActivity(activityId).subscribe(
          (data) => this.activity = data,
          (fail)=>  this.failMessage=fail.error.errorMessage
        )

      }
    )
  }
  update() {
   
    this.service.updateActivity(this.activity).subscribe(
      
      (resp)=>{
        console.log(this.activity);
       this.message = resp.message
       this.msgClass = 'alert alert-success'
       this.validationMessages=null;
      },
      (fail)=>{
        console.log(this.activity);
       this.message = fail.error.errorMessage;
       this.validationMessages=fail.error.errors;
       this.msgClass = 'alert alert-danger'
 
      }
 
    )
   
 }
 gotoList() {
  this.router.navigate(["activitylist"])
}

}
