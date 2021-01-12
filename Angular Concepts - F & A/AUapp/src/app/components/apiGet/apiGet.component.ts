import { CommonModule } from '@angular/common';
import { ApiCallServService } from './../../services/apiCall/apiCallServ.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-apiGet',
  templateUrl: './apiGet.component.html',
  styleUrls: ['./apiGet.component.css']
})

export class ApiGetComponent implements OnInit {

  constructor(private apiserv:ApiCallServService) {
    this.getApiData();
   }

  ngOnInit() {
    this.apiRecords = [];
  }

  apiRecords = [];

  getApiData(){
    this.apiserv.getRecords().subscribe( (response) =>{
      this.apiRecords = response;
    });
  }

}
