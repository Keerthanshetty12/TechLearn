import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { UserAssessment } from '../model/userAssessment';

@Injectable({
  providedIn: 'root'
})
export class UserAssessmentService {
  constructor(private http: HttpClient) { }

  baseUrl: string = "http://localhost:9090/userassessment";

  getAllUserAssessment(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
  saveUserAssessment(userassessment: UserAssessment) :Observable<any>{
    console.log(userassessment);
    return this.http.post(this.baseUrl,userassessment);
  }
  getUserAssessment(userName: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/userName${userName}`);
  }
}