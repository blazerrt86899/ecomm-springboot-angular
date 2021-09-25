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
}
