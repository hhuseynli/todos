import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  ifUserLoggedIn():boolean{
      let result:boolean = false;
      if(sessionStorage.getItem("authorization")){
        result=true;
      }
      return result;
  }
}
