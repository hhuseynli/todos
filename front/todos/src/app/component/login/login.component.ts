import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  realUsername: string = 'dea'
  realPassword: string = 'dea123'

  f

  loginButtonPressed() {
    if (this.username === this.realUsername && this.password === this.realPassword) {
      console.log(' Login successful ');
    } else {
      console.log(' Login failed ');
    }

  }




  ngOnInit() {

  }

}
