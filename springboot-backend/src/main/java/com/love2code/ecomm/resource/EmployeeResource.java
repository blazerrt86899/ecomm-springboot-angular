package com.love2code.ecomm.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.love2code.ecomm.model.Employee;
import com.love2code.ecomm.model.EmployeeResponseStatus;
import com.love2code.ecomm.service.IEmployeeService;

@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/api/v1/")
public class EmployeeResource {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path = "getEmployeeList", produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployeeList(){
		List<Employee> employees = employeeService.getEmployeeListService();
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	
	public ResponseEntity<EmployeeResponseStatus> createEmployee(@RequestBody Employee employee){
		EmployeeResponseStatus responseStatus = employeeService.createEmployeeService(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseStatus);
	
	}

}
