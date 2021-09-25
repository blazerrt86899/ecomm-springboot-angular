package com.love2code.ecomm.service;

import java.util.List;

import com.love2code.ecomm.model.Employee;
import com.love2code.ecomm.model.EmployeeResponseStatus;

public interface IEmployeeService {

	List<Employee> getEmployeeListService();

	EmployeeResponseStatus createEmployeeService(Employee employee);

}
