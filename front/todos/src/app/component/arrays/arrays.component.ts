import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
// import { enableProdMode } from '@angular/core';
// enableProdMode();

@Component({
  selector: 'app-arrays',
  templateUrl: './arrays.component.html',
  styleUrls: ['./arrays.component.css']
})
export class ArraysComponent implements OnInit {

  ngOnInit() {

    setTimeout(
      () => {
        this.allowButtonClick = true;
      },
      3000);

    this.imageURL = this.imagesArray[0];
  }


  fillArray() {
    this.numbers.push(Math.round(Math.random() * 10));
    let task: Task = new Task();
    task.id = this.tasks.length + 1;
    task.name = "task" + task.id;
    task.status = "Not done";
    task.day = 1;

    this.tasks.push(task)
  }
  
  numbers: number[] = [];
  tasks: Task[] = [];



  imageURL: string = '';
  imagesArray: string[] = [
    'https://earnprogramming.com/images/homes/001.jpg',
    'https://earnprogramming.com/images/homes/002.png',
    'https://earnprogramming.com/images/homes/003.jpg',
    'https://earnprogramming.com/images/homes/004.jpg'
  ]





  allowButtonClick: boolean = false;
  onNextImage() {
    if (this.imageIndex === this.imagesArray.length - 1) {
      this.imageIndex = -1;
    }
    this.imageURL = this.imagesArray[++this.imageIndex];

  }
  imageIndex: number = 0;






}
