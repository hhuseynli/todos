import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/service/todo.service';
import { Category } from '../model/task';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
 category: Category=new Category();
 
  constructor(private todoService :TodoService ) { }

  ngOnInit() {
  }

  onSaveCategory(){
   this.todoService.addCategoryToBackend(this.category);
  }

}
