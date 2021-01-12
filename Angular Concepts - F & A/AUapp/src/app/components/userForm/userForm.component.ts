import { HeaderComponent } from './../header/header.component';
import { customdate } from './customdate.pipe';
import { UserService } from './../../services/user/user.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import _ from 'lodash';

@Component({
  selector: 'app-userForm',
  templateUrl: './userForm.component.html',
  styleUrls: ['./userForm.component.css']
})
export class UserFormComponent implements OnInit {

  constructor(public userSer:UserService) { }

  ngOnInit() {
      this.userlist = this.userSer.getUserDetails();
  }

  userForm = new FormGroup({
    firstName: new FormControl('',[Validators.required]),
    lastName: new FormControl('',[Validators.required]),
    email: new FormControl('',[Validators.required]),
    mobile: new FormControl('',[Validators.required]),
    dob: new FormControl('',[Validators.required]),
  });

  errormsg:string;
  userlist=[];
  selectedCol:string;
  selectedType:string = 'asc';

  deleteSession(){
    this.userSer.delAllUsers();
    this.userlist = [];
    return false;
  }

  onSubmit(){
    if(this.userForm.invalid){
      console.log('Validation error',this.userForm.value);
      this.errormsg = "All fields are required";
    }else{
      this.errormsg = "";
      // console.log(this.userForm.value);
      // console.log('form submitting');
      this.userlist.push(this.userForm.value);
      this.userSer.pushuserdetails(this.userlist);
      console.log(this.userlist);
      this.userForm.reset();
    }
    return false;
  }

  sortdata(){
    console.log('chager');
    this.userlist =  _.orderBy(this.userlist, [this.selectedCol], [this.selectedType]);
  }

}
