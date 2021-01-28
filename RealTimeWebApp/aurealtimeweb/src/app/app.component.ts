import { element } from 'protractor';
import { async } from '@angular/core/testing';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'realtime-demo';
  
  orderId:number = 0;
  orderData;
  response;
  itemId:number;
  itemName:string;
  itemQuantity:number;
  validResponse:boolean = false;
  items = [];
  

  constructor(private http: HttpClient) {}

  createOrder(){
    console.log('posting '+this.orderId);
    const response = this.http.get<any>('/order/create/' + this.orderId).toPromise();
    response.then((data)=>{
        console.log(data.data);
        alert(data.data);
        return false;
    });
    response.catch((e)=>{
      this.cleardata();
      console.log(e);
      alert("some error occured");
      return false;
    })
  }

  addItem(){
    const body = {
      "itemId":this.itemId,
      "name":this.itemName,
      "quantity":this.itemQuantity
    }
    const response = this.http.post<any>('/order/'+this.orderId+'/item/add', body).toPromise();
    response.then((data)=>{
        console.log(data);
        alert(data.data);
        return false;
    });
    response.catch((e)=>{
      this.cleardata();
      console.log(e);
      alert("some error occured");
      return false;
    })
  }

  getOrderDetails(){
    this.validResponse = false;
    console.log("getting "+this.orderId);
    const response = this.http.get<any>('/order/find/' + this.orderId).toPromise();
    response.then((data)=>{
      this.validResponse = true;
      console.log(data.data);
      this.orderData = data.data;
      this.splitItems();
    });
    response.catch((e)=>{
      this.cleardata();
      console.log(e);
      alert("Error occured");
      return false;
    });
  }

  splitItems(){
    const itemdatum = this.orderData.itemHashMap;
    console.log("items object ",itemdatum);
    Object.keys(itemdatum).forEach(ele => {
      this.items.push(JSON.stringify(itemdatum[ele]));
      // console.log(this.items);
    });
  }

  cleardata(){
    this.validResponse = false;
    this.orderData = null;
    this.items = [];
  }

}