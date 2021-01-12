import { HeaderComponent } from './../header/header.component';
import { CalculatorService } from './../../services/calculator.service';
import { Component, OnInit } from '@angular/core';
import { Output } from '@angular/core';
import { Input } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor(private calc:CalculatorService){
  }

  @Output() result:number = 0;
  @Input() num1:number = 0;
  @Input() num2:number = 0;

  ngOnInit() {
    
  }

  calAdd(){ 
    console.log(this.num1+" "+this.num2);
    this.result = this.calc.add(this.num1,this.num2);
  }
  calSub(){ this.result = this.calc.subtract(this.num1,this.num2);}
  calMul(){ this.result = this.calc.multiply(this.num1,this.num2);}
  calDiv(){ this.result = this.calc.divide(this.num1,this.num2);}

}
