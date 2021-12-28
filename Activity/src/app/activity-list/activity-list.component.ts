import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Activity } from "../model/activity";
import { ActivityService } from "../services/activity.service";

@Component({
  selector: "activity-list",
  templateUrl: "./activity-list.component.html",
  styleUrls: ["./activity-list.component.css"],
})
export class ActivityListComponent implements OnInit {
  constructor(private service: ActivityService) {}

  ngOnInit(): void {
    this.loadData();
  }

  activity: Activity[];

  message: string = null;

 
  delete(activityId: number) {
    this.service.deleteActivity(activityId).subscribe(
      (resp) => {
        this.loadData();
        this.message = resp.message;
      },
      (response) => {
        this.message=response.error.errorMessage;
      }
    );
  }


  loadData() {
    this.service.getAllActivity().subscribe(
      (data) => (this.activity = data),
      (response) => (this.message = response.error.errorMessage)
    );
  }
}
