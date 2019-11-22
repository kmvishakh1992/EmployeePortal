import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { ProblemStatementComponent } from './problem-statement/problem-statement.component';

const routes: Routes = [
  { path:'', component: ProblemStatementComponent},
  { path: 'add', component:  AddEmployeeComponent},
  { path: 'list', component: ListEmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
