import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material';
import { AddTodoComponent } from '../add-todo/add-todo.component';
import { TodoService } from 'src/app/service/todo.service';
import { AgGridAngular } from 'ag-grid-angular';
import { Task } from '../model/task';
import { AddCategoryComponent } from '../add-category/add-category.component';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  todos: Task[] = [];

  constructor(private matDialog: MatDialog, public todoService: TodoService) { }

  ngOnInit() {

  }
  onAddTodo() {
    this.matDialog.open(AddTodoComponent);

  }
  onAddCategory() {
    this.matDialog.open(AddCategoryComponent);

  }
  onDeleteTodo(){
    let selectedRows=this.agGrid.api.getSelectedRows();
    
    if(selectedRows.length>0){
      for(let index = 0; index < selectedRows.length; index++){
        let task:Task=selectedRows[index];
       let id= task.id;
       console.log(index);
       this.todoService.deleteById(id).subscribe(
        resp=>{
          alert('Selected Row(s) Deleted');
          this.loadRows();
        }
      );
      }
    }else{
      alert('Select a row');
    }
  }
  onUpdateTodo(){
    let selectedRows=this.agGrid.api.getSelectedRows();
    
    if(selectedRows.length>0){
     
        let task:Task=selectedRows[0];
       this.todoService.selectedTask=task;
       this.matDialog.open(AddTodoComponent);     
      
      
    }else{
      alert('Select a row');
    }
}

  
  columnDefs = [
    { headerName: 'ID', field: 'id', sortable: true, filter: true, checkboxSelection: true, width: 100 },
    { headerName: 'Task', field: 'name', sortable: true, filter: true },
    { headerName: 'Day', field: 'day', sortable: true, filter: true },
     {headerName: 'Category Name', field: 'category.name', sortable: true, filter: true },
    { headerName: 'Start Date', field: 'start', sortable: true, filter: true },
    { headerName: 'Status', field: 'status', sortable: true, filter: true }
  ];
  onGridReady(event) {
    this.gridApi = event.api;
  }

  searchText: string = '';

  quickSearch() {
    this.gridApi.setQuickFilter(this.searchText);
  }
  @ViewChild('agGrid', { static: false }) agGrid: AgGridAngular;
  private gridApi;
  loadRows() {
   this.todoService.getAllTodos().subscribe(
      resp=>{
      this.todos= resp;
      }
      ); 
  }
x
}


