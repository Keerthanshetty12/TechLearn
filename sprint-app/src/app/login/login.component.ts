
import { Component } from '@angular/core';
import { Router } from "@angular/router";
import { AuthenticationService } from '../service/authentication.service';
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  message: string=null;
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService) { }

  signIn(credentials) {
    this.authenticationService.login(credentials)
      .subscribe(result => {
        this.router.navigate(['/home']);
        this.message=null;
      },
         fail => {
          this.message = fail.error.errorMessage;
        }
      );

  }
}
