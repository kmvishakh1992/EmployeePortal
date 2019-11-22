import { Component, OnInit, ViewChild } from '@angular/core';
import { EmployeeService } from '../service/employeeSvc';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  departmentList = ['Department1','Department2', 'Department3'];
  genderList = ['Female','Male'];
  departmentCat: string = '';
  genderCat: string = ''
  employeeList: IEmployee;
  isSuccess: boolean = false;
  isError: boolean = false

  @ViewChild('myform') form: NgForm;

  constructor(private _empSvc: EmployeeService) { }
  
  ngOnInit() {
  }

  register(f: NgForm) {
    if(f.valid){
      this.employeeList = f.value;
      this.saveEmployee(this.employeeList);
    }
}

  saveEmployee(data) {
    this._empSvc.saveEmployees(data).subscribe(
      response => this.sucess(response),
      error => this.error(error)
    );
  }

  sucess(response) {
    this.employeeList = response;
    this.isSuccess = true;
    this.form.resetForm();
  }

  error(error) {
    this.isError = true;
  }

}
