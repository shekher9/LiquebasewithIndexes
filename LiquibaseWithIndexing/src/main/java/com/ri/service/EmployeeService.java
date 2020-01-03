package com.ri.service;

import java.util.List;

import com.ri.entity.Employee;

public interface EmployeeService {
	public boolean saveEmployee(Employee emp);
	public List<Employee> getallEmployee();
	public Employee getEmployeeById(int id);
	//public boolean updateEmployeeById(Employee emp);
	public boolean removeEmployeeById(int id);

}
