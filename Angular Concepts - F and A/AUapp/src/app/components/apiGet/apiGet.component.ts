import { ApiCallServService } from './../../services/apiCall/apiCallServ.service';
import { Component, OnInit, Input } from '@angular/core';
import { UserService } from './../../services/user/user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import _ from 'lodash';

@Component({
  selector: 'app-apiGet',
  templateUrl: './apiGet.component.html',
  styleUrls: ['./apiGet.component.css']
})

export class ApiGetComponent implements OnInit {

  constructor(public userSer:UserService) {
  }

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
  apiRecords = [];
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
