import { Component, OnInit } from '@angular/core';
import { Activity } from '../model/activity';
import { ActivityService } from '../service/activity.service';

@Component({
  selector: 'app-activity-list',
  templateUrl: './activity-list.component.html',
  styleUrls: ['./activity-list.component.css']
})
export class ActivityListComponent implements OnInit {

  constructor(private service: ActivityService) {}

  ngOnInit(): void {
    this.loadData();
  }

  header: string = "List of Activities";

  activity: Activity[];

  message: string = null;
  failMessage: string = null;

  delete(activityId: number): void {
    console.log(activityId);
    this.service.deleteActivity(activityId).subscribe(
      (resp) => {
        this.message = resp.message;
        this.loadData();
      },
      (errorResponse) => {

        this.message = errorResponse.error.errorMessage
        this.loadData();
      }
    )

  }

  loadData(): void {
    this.service.getAllActivity().subscribe(
      (data) => {
        this.activity = data;
      },
      (errorResponse) => {
        this.failMessage = errorResponse.error.errorMessage
      }
    )
  }

  updateComplete(message: string) {
    this.message = message;
  }

}
