import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ngOnInit(): void {
   
  }

  constructor(private http:HttpClient, private router:Router ){

  }

  username: string = '';
  password: string = '';



  loginButtonPressed() {
    let HeaderString = 'Basic ' + window.btoa(this.username + ':' + this.password);
    let HeaderObject = new HttpHeaders(
      {
        Authorization: HeaderString
      }
    );

    this.http.get<boolean>('http://localhost:8080/validations', {
      headers: HeaderObject
    }).subscribe(
      success => {
        sessionStorage.setItem("authorization", HeaderString);
        this.router.navigate(['todos']);

      },error=>{
        alert('Bad credentials');
      }


    );

}
}
