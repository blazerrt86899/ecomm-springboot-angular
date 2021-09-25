import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/employee';
import { EmployeeResponse } from 'src/app/employee-response';
import { EmployeeService } from 'src/app/service/employee.service';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  response: EmployeeResponse;
  constructor(private employeeService : EmployeeService,
    private route : Router) { }

  ngOnInit(): void {
  }
  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(
      data => {
        this.response = data;
        this.goToEmployeeList();
      },
      error => console.log(error)
    );
  }
  goToEmployeeList(){
    this.route.navigate(['/employees']);
  }
  onSubmit(){
   console.log(this.employee);
   this.saveEmployee();
  }

}
