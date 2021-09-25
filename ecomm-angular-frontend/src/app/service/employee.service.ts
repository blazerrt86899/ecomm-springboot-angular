import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeResponse } from '../employee-response';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:9001/api/v1/";
  constructor(private httpClient : HttpClient) { }

  getEmployeeList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`+`getEmployeeList`);
  }

  createEmployee(employee : Employee): Observable<EmployeeResponse>{
    return this.httpClient.post<EmployeeResponse>(`${this.baseURL}`+`employees`,employee);
  }

  getEmployeeById(id:number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}`+`employee/${id}`);
  }

  updateEmployee(id:number, employee: Employee): Observable<EmployeeResponse>{
    return this.httpClient.put<EmployeeResponse>(`${this.baseURL}`+`employee/update/${id}`,employee);
  }

  deleteEmployee(id:number):Observable<EmployeeResponse>{
    return this.httpClient.delete<EmployeeResponse>(`${this.baseURL}/employee/${id}`);
  }
}
