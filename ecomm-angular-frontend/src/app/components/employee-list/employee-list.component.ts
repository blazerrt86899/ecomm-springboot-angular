import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/employee';
import { EmployeeResponse } from 'src/app/employee-response';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees : Employee[];
  response : EmployeeResponse;
  constructor(private employeeService : EmployeeService,
    private route : Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

   getEmployees(){
    this.employeeService.getEmployeeList().subscribe(
      data => {
        this.employees = data;
      }
    )
  }

  updateEmployee(id:number){
    this.route.navigate(['/update-employee',id]);
  }

  employeeDetails(id:number){
    this.route.navigate(['/employee-details',id]);
  }

  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(
      data => {
        this.getEmployees();
        this.response = data;
      },
      error => console.log(error)
    );
  }

}
