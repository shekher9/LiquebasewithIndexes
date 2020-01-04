package com.ri.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EmployeeModel implements Serializable {
	private Integer id;
	private String employeeid;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private long mobile;


}
