package com.love2code.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love2code.ecomm.model.Employee;

@Repository 
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
