import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  baseUrl: string = "http://localhost:9090/user";



  getAllUsers(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  saveUser(user: User): Observable<any> {
    console.log(user);
    return this.http.post(this.baseUrl, user);
  }

  deleteUser(userName: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/userName${userName}`);
  }
  updateUser(user: User): Observable<any> {
    return this.http.put(this.baseUrl, user);
  }
  getUser(userName: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/userName${userName}`);
  }

}
