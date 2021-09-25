package com.love2code.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.ecomm.exception.ResourceNotFoundException;
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

	@Override
	public Employee getEmployeeByIdService(Long id) {
		return employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id " + id));
	}

	@Override
	public EmployeeResponseStatus updateEmployeeService(Employee employee, Long id) {
		Employee oldEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id " + id));
		oldEmployee.setFirstName(employee.getFirstName());
		oldEmployee.setLastName(employee.getLastName());
		oldEmployee.setEmailId(employee.getEmailId());
		
		Employee newEmployee = employeeRepository.save(oldEmployee);
		return new EmployeeResponseStatus("Employee data updated with id " + id);
	}

	@Override
	public EmployeeResponseStatus deleteEmployeeDetails(Long id) {
		employeeRepository.deleteById(id);
		return new EmployeeResponseStatus("Employee Removed with id " + id);
	}

}
