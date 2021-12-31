import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { AuthGuardService } from './service/auth-guard.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { UserActivityListComponent } from './user-activity-list/user-activity-list.component';
import { CreateUserActivityComponent } from './create-user-activity/create-user-activity.component';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { CreateActivityComponent } from './create-activity/create-activity.component';
import { ActivityUpdateComponent } from './activity-update/activity-update.component';
import { AssessmentListComponent } from './assessment-list/assessment-list.component';
import { CreateAssessmentComponent } from './create-assessment/create-assessment.component';
import { UserAssessmentListComponent } from './user-assessment-list/user-assessment-list.component';
import { CreateUserAssessmentComponent } from './create-user-assessment/create-user-assessment.component';



const routes: Routes = [ 
  {path:'userlist',component:UserListComponent,canActivate:[AuthGuardService]},
  {path:'createUser',component:CreateUserComponent,canActivate:[AuthGuardService]},
  {path:'update/:userName',component:UserUpdateComponent,canActivate:[AuthGuardService]},
  {path:'userList/:userName',component:UserListComponent},

  {path:'activitylist',component:ActivityListComponent},
  {path:'create',component:CreateActivityComponent},
  {path:'updateActivity/:activityId',component:ActivityUpdateComponent},

  {path:'assessmentlist',component:AssessmentListComponent},
  {path:'createAssessment',component:CreateAssessmentComponent},

  {path:'userActivitylist',component:UserActivityListComponent},
  {path:'userActivityCreate',component:CreateUserActivityComponent},

  {path:'userAssessmentlist',component:UserAssessmentListComponent},
  {path:'userAssessmentCreate',component:CreateUserAssessmentComponent},

  {path:'home',component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'logout',component:LogoutComponent}]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
