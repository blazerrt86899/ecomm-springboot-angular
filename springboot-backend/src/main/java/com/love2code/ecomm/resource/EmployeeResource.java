package com.love2code.ecomm.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.love2code.ecomm.model.Employee;
import com.love2code.ecomm.model.EmployeeResponseStatus;
import com.love2code.ecomm.service.IEmployeeService;

@CrossOrigin(value = {"http://localhost:4200/"})
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
	
	@PostMapping(path = "employees", consumes = "application/json", produces = "application/json")
	public ResponseEntity<EmployeeResponseStatus> createEmployee(@RequestBody Employee employee){
		EmployeeResponseStatus responseStatus = employeeService.createEmployeeService(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseStatus);
	
	}
	
	@GetMapping(path = "employee/{id}", produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee requestedEmployee = employeeService.getEmployeeByIdService(id);
		return ResponseEntity.status(HttpStatus.OK).body(requestedEmployee);
	}
	
	@PutMapping(path = "employee/update/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<EmployeeResponseStatus> updateEmployeeDetails(@PathVariable("id") Long id, @RequestBody Employee employee){
		EmployeeResponseStatus updateResponse = employeeService.updateEmployeeService(employee,id);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateResponse);
	}
	
	@DeleteMapping(path = "employee/{id}")
	public ResponseEntity<EmployeeResponseStatus> deleteEmployeeDetails(@PathVariable("id") Long id){
		EmployeeResponseStatus deleteResponse = employeeService.deleteEmployeeDetails(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleteResponse);
	}

}
