import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { ActivityListComponent } from './activity-list/activity-list.component';
import { ActivityUpdateComponent } from './activity-update/activity-update.component';
import { ActivityCreateComponent } from './activity-create/activity-create.component';


@NgModule({
  declarations: [
    AppComponent,
    ActivityListComponent,
    ActivityUpdateComponent,
    ActivityCreateComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
