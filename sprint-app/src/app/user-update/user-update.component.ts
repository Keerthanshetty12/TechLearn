import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  constructor(private service: UserService,
    private route: ActivatedRoute,  // required to extract route parameters
    private router: Router)  // required for navigation to list component after successful update
    { } 

   user:User={userName:"",password:"",firstName:"",lastName:"",emailId:"",role:""}
   
  msgClass: string;
  message: string = null;
  failMessage: string = null;
  validationMessages:string[]=null;
  
  ngOnInit() {
    this.route.paramMap.subscribe(
      (param) => {
      let userName:string = param.get('userName')
      console.log(userName);
      this.service.getUser(userName).subscribe(
          (data) =>(this.user = data),
          (fail)=>(this.failMessage=fail.error.errorMessage)
        )
      }
    )
    }
  // this method is called when data update to be done and update button is clicked
update() {
  console.log("hii ");
  this.service.updateUser(this.user).subscribe(
    (resp)=>{
      console.log(resp);
     this.message = resp.message
     this.msgClass = 'alert alert-success'
     this.validationMessages=null;
    },
    (fail)=>{
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
