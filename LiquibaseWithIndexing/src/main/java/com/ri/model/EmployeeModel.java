package com.ri.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class EmployeeModel implements Serializable {
	private Integer employeeid;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private long mobile;


}
