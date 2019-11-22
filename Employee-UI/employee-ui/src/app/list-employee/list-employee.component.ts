import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employeeSvc';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  employeeData = [
    {
      firstName: 'test1',
      lastName: 'lname1',
      gender: 'male',
      dob: 'test',
      department: 'dept1'
    },
    {
      firstName: 'test2',
      lastName: 'lname1',
      gender: 'male',
      dob: 'test',
      department: 'dept1'
    },
    {
      firstName: 'test3',
      lastName: 'lname1',
      gender: 'male',
      dob: 'test',
      department: 'dept1'
    }
  ];
  employeeList: IEmployee;
  constructor(private _empSvc: EmployeeService) { }

  ngOnInit() {
    this.getList();
  }

  getList() {
    this._empSvc.getEmployees().subscribe(
      response => this.sucess(response),
      error => this.error(error)
    );
  }
  sucess(response) {
    this.employeeList = response;
    console.log(this.employeeList);
  }
  error(error) {
    //this.account='something went wrong';
  }
}
