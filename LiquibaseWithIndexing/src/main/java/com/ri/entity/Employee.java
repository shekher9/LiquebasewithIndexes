package com.ri.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
@Data
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;
	@GeneratedValue(generator="id_seq",strategy=GenerationType.SEQUENCE)
	@GenericGenerator(
			name="id_seq",
			strategy=""
			/*parameters= {
					 Parameter(name=,value="1")
			}*/
			)
	private String empid;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private long mobile;

}
