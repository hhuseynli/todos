import { Injectable } from '@angular/core';
import { Task, Category } from '../component/model/task';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class TodoService {
 

  constructor(private http:HttpClient) { }

  public getAllTodos() {
    return this.http.get<Task[]>('http://localhost:8080/todos/todo');

  }
 

  public addTodoToBackend(todo:Task){
    this.http.post('http://localhost:8080/todos/todo',todo).subscribe();
  }
    public addCategoryToBackend(category:Category){
    this.http.post('http://localhost:8080/categories/category',category).subscribe();
  }
  
  public getAllCategories() {
     return this.http.get<Category[]>('http://localhost:8080/categories/category');

  }

}
