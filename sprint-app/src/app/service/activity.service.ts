import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { Activity } from '../model/activity';
@Injectable({
  providedIn: 'root'
})
export class ActivityService {
  constructor(private http: HttpClient) {}

  baseUrl: string = "http://localhost:9090/activity";

  getActivity(activityId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${activityId}`);
  }

  getAllActivity(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  saveActivity(activity: Activity): Observable<any> {
    return this.http.post(this.baseUrl, activity);
  }

  updateActivity(activity: Activity): Observable<any> {
   
    return this.http.put(this.baseUrl, activity);
  }

  deleteActivity(activityId: number): Observable<any> {
   
    return this.http.delete(`${this.baseUrl}/${activityId}`);
  }
}
