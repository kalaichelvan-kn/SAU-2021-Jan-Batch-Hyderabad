import { HeaderComponent } from './components/header/header.component';
import { customdate } from './components/userForm/customdate.pipe';
import { CommonModule } from '@angular/common';
import { UserFormComponent } from './components/userForm/userForm.component';
import { CalculatorComponent } from './components/calculator/calculator.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MybootstrapModule } from './modules/mybootstrap/mybootstrap.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    UserFormComponent,
    HeaderComponent,
    customdate
  ],
  imports: [
    AppRoutingModule,
    CommonModule,
    BrowserModule,
    MybootstrapModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }