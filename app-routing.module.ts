import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserCreateComponent } from '../new/user-create/user-create.component';
import { UserDetailsComponent } from './Components/user-details/user-details.component';
import { UserListComponent } from './Components/user-list/user-list.component';
import { UserLoginComponent } from './Components/user-login/user-login.component';
import { UserUpdateComponent } from './Components/user-update/user-update.component';

const routes: Routes = [
  {path: '', redirectTo:'users', pathMatch:'full'},
  {path: 'users', component: UserListComponent},
  {path: 'users/:uname', component: UserDetailsComponent},
  {path: 'create', component: UserCreateComponent},
  {path:'update', component:UserUpdateComponent},
  {path: 'login', component: UserLoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
