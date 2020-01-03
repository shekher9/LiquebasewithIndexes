package com.ri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ri.entity.Employee;

@Repository(value = "employeerepo")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByemployeeid(int id);
	

}
