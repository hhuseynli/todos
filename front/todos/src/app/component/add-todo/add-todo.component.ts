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
    // let category1: Category = new Category();
    // category1.id = 1;
    // category1.name = "Learning Language";

    // let category2: Category = new Category();
    // category2.id = 2;
    // category2.name = "Reading Book";

    // this.categories.push(category1, category2);
    // this.task.category.id = 1;
    
      
  }

  



  onSaveTask() {
    // let todo: Task = new Task();
    // todo.id = (this.todoService.todos.length + 1);
    // todo.name = this.task.name;
    // todo.category.name = this.task.category.name;
    // todo.start = this.task.start;
    // todo.day = this.task.day;
    // todo.status = "Not Completed";
    // this.todoService.todos.push(todo);
    this.todoService.addTodoToBackend(this.task);

  }
}
}
