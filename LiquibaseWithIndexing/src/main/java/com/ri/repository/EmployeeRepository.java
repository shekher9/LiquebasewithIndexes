package com.ri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ri.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
