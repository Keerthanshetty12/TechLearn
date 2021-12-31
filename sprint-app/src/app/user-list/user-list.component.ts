
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private service: UserService) { }

  ngOnInit() {
    this.loadData();
  }

  user: User[];
  failMessage:string=null;
  message: string = null;

  delete(username: string) {
    this.service.deleteUser(username).subscribe(
      (resp) => {
        this.loadData();
        this.message = resp.message;
      },
      (response) => {
        this.message=response.error.errorMessage;
        
      }
    );
  }
 
  loadData():void {
    this.service.getAllUsers().subscribe(
      (data) =>{
        (this.user = data);
      },
      (errorResponse) =>{ (this.failMessage =errorResponse.error.details);
        console.log(errorResponse);
      }
    )
  }

}
