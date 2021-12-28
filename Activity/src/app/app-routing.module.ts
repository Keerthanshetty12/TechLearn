import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActivityCreateComponent } from './activity-create/activity-create.component';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { ActivityUpdateComponent } from './activity-update/activity-update.component';

const routes: Routes = [
  {path:'activitylist',component:ActivityListComponent},
  {path:'create',component:ActivityCreateComponent},
  {path:'update/:activityId',component:ActivityUpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
