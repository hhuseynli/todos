import { Component, OnInit } from '@angular/core';
import { Task, Category } from '../model/task';
import { TodoService } from 'src/app/service/todo.service';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})
export class AddTodoComponent implements OnInit {

  task: Task = new Task();
  categories: Category[] = [];

  constructor(private todoService: TodoService) {
  }

  ngOnInit() {
  
    this.todoService.getAllCategories().subscribe(
      resp => {

        this.categories = resp;
      }
    );
    if(this.todoService.selectedTask!=null){
      this.task=this.todoService.selectedTask;
    }  


  }





  onSaveTask() {
    
     this.task.category.name=this.categories[this.task.category.id-1].name;
    console.log(this.task);
    this.todoService.addTodoToBackend(this.task);
    alert("Please refresh table for now");
    
  }


  

}

