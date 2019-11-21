import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  departmentList = ['Department1','Department2', 'Department3'];
  genderList = ['Female','Male'];
  department: string = 'Department1';
  gender: string = 'Male'

  constructor() { }

  ngOnInit() {
  }

}
