import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {


  message: string = null;
  validationMessages:string[]=null;
  constructor(private service: UserService, private router:Router) { }

  ngOnInit() {
  }

  
msgClass:string;
failMessage:string=null;
createNew(data: User) {
  console.log(data);
  this.service.saveUser(data).subscribe(
    (resp)=>{
     this.message = resp.message
     this.msgClass = 'alert alert-success'
     this.validationMessages=null;
    },
    (fail)=>{
      console.log(data);
     this.message = fail.error.errorMessage;
     this.validationMessages=fail.error.errors;
     this.msgClass = 'alert alert-danger'

    }

  )
 }

gotoList() {
this.router.navigate(["userlist"])
}

}
