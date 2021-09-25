import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/employee';
import { EmployeeResponse } from 'src/app/employee-response';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(private employeeService : EmployeeService,
    private activatedRoute : ActivatedRoute,
    private route : Router) { }
  updateEmployee : Employee;
  id:number;
  response:EmployeeResponse;

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.getEmployeeDetailById(this.id);
  }

  getEmployeeDetailById(id:number){
    this.employeeService.getEmployeeById(id).subscribe(
      data =>{
        this.updateEmployee = data;
      },
      error => console.log(error)
    );
  }

  update(){
    this.employeeService.updateEmployee(this.id,this.updateEmployee).subscribe(
      data => {
        this.response = data;
        this.route.navigate(['/employees']);
      },
      error => console.log(error)
    );
  }

}
