import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Activity } from '../model/activity';
import { User } from '../model/user';
import { UserActivity } from '../model/user-activity';
import { ActivityService } from '../service/activity.service';
import { UserActivityService } from '../service/user-activity.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-create-user-activity',
  templateUrl: './create-user-activity.component.html',
  styleUrls: ['./create-user-activity.component.css']
})
export class CreateUserActivityComponent implements OnInit {
  
 
  
  errorMessage: string=null;
  msgClass:string;

  message: string = null;
  validationMessages:string[];
  
  constructor(private service: UserActivityService,
    private userservice:UserService,
    private activityservice:ActivityService, 
    private router:Router,
     ) { }

  activitys:Activity[];
  users:User[];

  ngOnInit() {
    this.userservice.getAllUsers().subscribe(
      (data)=>this.users=data,
      )
      this.activityservice.getAllActivity().subscribe(
        (data)=>this.activitys=data,
        )
  }

  saveData(data) {
   let user:User={userName:data.user,password:null,firstName:null,lastName:null,emailId:null,role:null};
   let activity:Activity={activityId:data.activity,activityName:null,startDate:null,endDate:null,duration:null};
   let useractivity:UserActivity={userActivityId:data.userActivityId,user:user,activity:activity,status:data.status,startDate:data.startDate};
   
   console.log(useractivity);
    this.service.saveUserActivity(useractivity).subscribe(
      (resp)=>{
       this.message = resp.message
       this.msgClass = 'alert alert-success'
       this.validationMessages=null;
      },
      (fail)=>{
        console.log(useractivity);
       this.message = fail.error.errorMessage;
       this.validationMessages=fail.error.errors;
       this.msgClass = 'alert alert-danger'
  
      }
  
    )
   }
  
  gotoList() {
  this.router.navigate(["userActivitylist"])
  }
  
}
