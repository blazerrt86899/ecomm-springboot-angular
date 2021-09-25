package com.love2code.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.ecomm.model.Employee;
import com.love2code.ecomm.model.EmployeeResponseStatus;
import com.love2code.ecomm.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployeeListService() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeResponseStatus createEmployeeService(Employee employee) {
		Employee createdEmployee =  employeeRepository.save(employee);
		return new EmployeeResponseStatus("Employee Created Successfully");
	}

}
