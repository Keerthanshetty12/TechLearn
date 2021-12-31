import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserActivity } from '../model/user-activity';
import { ActivityService } from '../service/activity.service';
import { UserActivityService } from '../service/user-activity.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-activity-list',
  templateUrl: './user-activity-list.component.html',
  styleUrls: ['./user-activity-list.component.css']
})
export class UserActivityListComponent implements OnInit {

  constructor(private service: UserActivityService,private userservice:UserService,
    private activityservice:ActivityService,private router:Router ) { }

  ngOnInit() {
    this.loadData();
  }
  useractivity: UserActivity[];
  message: string = null;
  activityid:number[];
  userName:string[];
  
  loadData() {
    this.service.getAllUserActivity().subscribe(
      (data) => (this.useractivity = data),
      (response) => (this.message = response.error.errorMessage)
    );
  }
}
