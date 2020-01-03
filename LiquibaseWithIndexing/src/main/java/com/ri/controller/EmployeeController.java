package com.ri.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ri.entity.Employee;
import com.ri.model.EmployeeModel;
import com.ri.response.EmployeeResponse;
import com.ri.service.EmployeeService;



@RestController
@Consumes(value = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,})
@Produces(value = MediaType.APPLICATION_JSON)
public class EmployeeController {
	
	@Autowired(required = true)
	private EmployeeService empservice;
	
	@PostMapping(value = "emp/save")
	public EmployeeResponse registerNewEmployee(@RequestParam EmployeeModel model) {
		Employee emp=new Employee();
		EmployeeResponse responce=new EmployeeResponse();
		boolean flag=false;
		BeanUtils.copyProperties(model, emp);
		flag=empservice.saveEmployee(emp);
		if(flag) {
			responce.setStatus(200);
			responce.setMessage("Employee Data saved ");
		}
		else {
			responce.setStatus(400);
			responce.setMessage("Employee data not saved");
		}
		return responce;
	}
	
	public List<EmployeeModel> fechAllEmployee(){
		List<Employee>emplist=new ArrayList<Employee>();
		emplist=empservice.getallEmployee();
		emplist.forEach(emp->{
			
		});
	} 
	

}
