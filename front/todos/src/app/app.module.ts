import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { FormsModule } from '@angular/forms';
import { ArraysComponent } from './component/arrays/arrays.component';
import { StudentListComponent } from './component/student-list/student-list.component';
import { TodoListComponent } from './component/todo-list/todo-list.component';
import { AddTodoComponent } from './component/add-todo/add-todo.component';
import { AddCategoryComponent } from './component/add-category/add-category.component'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule, MatDialogModule, MatProgressSpinnerModule, MatButtonModule }
  from '@angular/material';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BasicInterceptorService } from './service/basic-interceptor.service';
import { MenuComponentComponent } from './component/menu-component/menu-component.component';
import { LogOutComponent } from './component/log-out/log-out.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ArraysComponent,
    StudentListComponent,
    TodoListComponent,
    AddTodoComponent,
    AddCategoryComponent,
    MenuComponentComponent,
    LogOutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatDialogModule,
    MatProgressSpinnerModule,
    MatButtonModule,
    HttpClientModule,
    AgGridModule.withComponents([])
  ],
  providers: [{provide:HTTP_INTERCEPTORS ,useClass:BasicInterceptorService,multi:true}],
  bootstrap: [AppComponent],
  entryComponents: [AddTodoComponent, AddCategoryComponent]
})
export class AppModule { }
