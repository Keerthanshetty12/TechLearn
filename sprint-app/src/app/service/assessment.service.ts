import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { Assessment } from '../model/assessment';

@Injectable({
  providedIn: 'root'
})
export class AssessmentService {

  constructor(private http:HttpClient) { }

  baseUrl:string="http://localhost:9090/assessment"

  getAll(): Observable<any> {
    return this.http.get(this.baseUrl);
  }
  
  deleteAssessment(assessmentId: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/${assessmentId}`)
  }
  
  getAssessment(assessmentId:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/${assessmentId}`);
  }
  
  saveAssessment(x:Assessment):Observable<any> {
    return this.http.post(this.baseUrl,x);
  
  }
}
