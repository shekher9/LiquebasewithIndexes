package com.ri.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ri.entity.Employee;
import com.ri.repository.EmployeeRepository;

@Service(value = "empservice")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired(required = true)
	private EmployeeRepository employeerepo;
	@Override
	public boolean saveEmployee(Employee emp) {
		Employee emp1=new Employee();
		emp1=employeerepo.save(emp);
		if(emp1.getId()!=null)
			return true;
		else
		return false;
	}

	@Override
	public List<Employee> getallEmployee() {
		return employeerepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return employeerepo.findByemployeeid(id);
		 
	}

	/*
	 * @Override public boolean updateEmployeeById(Employee emp) { Employee emp1=new
	 * Employee(); emp1=employeerepo.save(emp);
	 * 
	 * return null; }
	 */

	@Override
	public boolean removeEmployeeById(int id) {
		employeerepo.deleteById(id);
		Employee emp=employeerepo.findByemployeeid(id);
		if(emp.getId()==null)
		return true;
		else 
			return false;
	}

}
