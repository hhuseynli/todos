import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TodoListComponent } from './component/todo-list/todo-list.component';
import { LoginComponent } from './component/login/login.component';
import { LogOutComponent } from './component/log-out/log-out.component';


const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"login",component:LoginComponent},
  {path:"todos",component:TodoListComponent},
  {path:"logout",component:LogOutComponent},
  {path:"**",component:LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
