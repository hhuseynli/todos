import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-menu-component',
  templateUrl: './menu-component.component.html',
  styleUrls: ['./menu-component.component.css']
})
export class MenuComponentComponent implements OnInit {


  constructor(private userService:UserService) { }

ifUserLoggedIn():boolean{
  return this.userService.ifUserLoggedIn();
}
ngOnInit(){
  
}
 

}
