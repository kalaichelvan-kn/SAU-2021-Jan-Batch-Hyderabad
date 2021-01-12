import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

constructor() { }

pushuserdetails(userArray:Array<any>){
  sessionStorage.setItem("userList",JSON.stringify(userArray));
}

getUserDetails(){
  var ss = sessionStorage.getItem('userList');
    if(ss!=null){ return JSON.parse(ss); }else{ return []; }
}

delAllUsers(){
  sessionStorage.removeItem('userList');
}

}
