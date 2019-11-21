import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  employeeData=[
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

  constructor() { }

  ngOnInit() {
  }

}
