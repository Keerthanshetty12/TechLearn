import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { UserActivity } from '../model/user-activity';

@Injectable({
  providedIn: 'root'
})
export class UserActivityService {

  constructor(private http: HttpClient) { }

  baseUrl: string = "http://localhost:9090/useractivity";

  getAllUserActivity(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
  saveUserActivity(useractivity: UserActivity) :Observable<any>{
    console.log(useractivity);
    return this.http.post(this.baseUrl,useractivity);
  }
  getUser(userName: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/userName${userName}`);
  }
  
}
