import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { FormsModule } from '@angular/forms';
import { JwtInterceptorService } from './service/jwt-interceptor.service';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { LoginComponent } from './login/login.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { UserAssessmentListComponent } from './user-assessment-list/user-assessment-list.component';
import { UserActivityListComponent } from './user-activity-list/user-activity-list.component';
import { CreateUserActivityComponent } from './create-user-activity/create-user-activity.component';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { CreateActivityComponent } from './create-activity/create-activity.component';
import { ActivityUpdateComponent } from './activity-update/activity-update.component';
import { AssessmentListComponent } from './assessment-list/assessment-list.component';
import { CreateAssessmentComponent } from './create-assessment/create-assessment.component';
import { CreateUserAssessmentComponent } from './create-user-assessment/create-user-assessment.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule, MatButtonModule, MatSelectModule, MatIconModule } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    LoginComponent,
    LogoutComponent,
    HomeComponent,
    CreateUserComponent,
    UserUpdateComponent,
    UserAssessmentListComponent,
    UserActivityListComponent,
    CreateUserActivityComponent,
    ActivityListComponent,
    CreateActivityComponent,
    ActivityUpdateComponent,
    AssessmentListComponent,
    CreateAssessmentComponent,
    CreateUserAssessmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatIconModule
  

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorService,multi:true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
