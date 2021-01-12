import { ApiGetComponent } from './components/apiGet/apiGet.component';
import { UserFormComponent } from './components/userForm/userForm.component';
import { CalculatorComponent } from './components/calculator/calculator.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', component: ApiGetComponent },
  { path: 'apiCall', component: ApiGetComponent },
  { path: 'calculator', component: CalculatorComponent },
  { path: 'userform', component: UserFormComponent },
  { path: '**', component: UserFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
