import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserLoginComponent } from './Components/user-login/user-login.component';
import { UserUpdateComponent } from './Components/user-update/user-update.component';
import { UserListComponent } from './Components/user-list/user-list.component';
import { UserCreateComponent } from '../new/user-create/user-create.component';
import { UserDetailsComponent } from './Components/user-details/user-details.component';


@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    UserUpdateComponent,
    UserListComponent,
    UserDetailsComponent,
    UserCreateComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
