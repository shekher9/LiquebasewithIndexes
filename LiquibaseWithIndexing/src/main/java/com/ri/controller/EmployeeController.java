package com.ri.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ri.entity.Employee;
import com.ri.model.EmployeeModel;
import com.ri.response.EmployeeResponse;
import com.ri.service.EmployeeService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;



@RestController
@Consumes(value = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces(value = MediaType.APPLICATION_JSON)
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired(required = true)
	private EmployeeService empservice;
	
	@GetMapping("/demo")
	public EmployeeModel getDemo() {
		EmployeeModel model=new EmployeeModel();
		model.setId(000);
		model.setEmployeeid("RI_000");
		model.setFirstname("raja");
		model.setLastname("kumar");
		model.setGender("Male");
		model.setEmail("rajakumar@gmail.com");
		model.setMobile(9087654321L);
		return model;
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Object>   registerNewEmployee(@RequestBody EmployeeModel model) {
		Employee emp=new Employee();
		EmployeeResponse response=null;
		boolean flag=false;
		BeanUtils.copyProperties(model, emp);
		flag=empservice.saveEmployee(emp);
		if(flag) {
			 response=EmployeeResponse.builder().message("Data saved").status(HttpStatus.OK).build();
			
		}
		else {
			 response =EmployeeResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message("Employee data not saved").build();
		}
		return ResponseEntity.ok(response);
	}
	@GetMapping(value = "/allemployee")
	public List<EmployeeModel> fechAllEmployee(){
		List<Employee>emplist=new ArrayList<Employee>();
		List<EmployeeModel> empmodellist=new ArrayList<EmployeeModel>();
		emplist=empservice.getallEmployee();
		emplist.forEach(emp->{
			EmployeeModel model=new EmployeeModel();
			BeanUtils.copyProperties(emp, model);
			empmodellist.add(model);
			
		});
		
		return empmodellist ;
	} 
	
	@GetMapping(value = "/employee/{id}")
	public EmployeeModel getEmployeeById(@PathParam(value = "id") int id) {
		Employee emp=empservice.getEmployeeById(id);
		EmployeeModel model=new EmployeeModel();
		BeanUtils.copyProperties(emp, model);
		return model;
	}
	@PutMapping(value = "/updateEmployee/{id}")
	public ResponseEntity<Object> updateEmployeeDetails(@RequestBody EmployeeModel model,@PathParam(value = "")  int id){
		Employee emp=new Employee();
		EmployeeResponse response=null;
		BeanUtils.copyProperties(model, emp);
		boolean flag=empservice.updateEmployeeById(id, emp);
		if(flag) {
			response=EmployeeResponse.builder().status(HttpStatus.FOUND).message("Employee data updated").build();
		}
		else
			response=EmployeeResponse.builder().status(HttpStatus.NOT_FOUND).message("EMployee data not found").build();
		return ResponseEntity.ok(response);
	}
	@DeleteMapping(value = "/removeEmployee/{id}")
	public ResponseEntity<Object> removeEmployee(@PathParam(value = "id") int id){
		boolean flag=empservice.removeEmployeeById(id);
		EmployeeResponse response=null;
		if(flag)
			response=EmployeeResponse.builder().status(HttpStatus.FOUND).message("Ëmployee is deleted").build();
		else
			response=EmployeeResponse.builder().status(HttpStatus.NOT_FOUND).message("Employee not deleted").build();
		return ResponseEntity.ok(response);
		
	}
	
	
}
