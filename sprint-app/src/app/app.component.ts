import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private service:AuthenticationService,private router:Router){

  }
 
  title = 'Teach Learn Application';
  gotoList(){
    this.router.navigate(["userlist"])
    
  }
}
