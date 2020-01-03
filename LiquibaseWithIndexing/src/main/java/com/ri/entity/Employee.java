package com.ri.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="EMPLOYE")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	@Column
	@GeneratedValue(generator="id_seq",strategy=GenerationType.SEQUENCE)
	@GenericGenerator(
			name="id_seq",
			strategy=""
			/*parameters= {
					 Parameter(name=,value="1")
			}*/
			)
	private String employeeid;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String gender;
	@Column
	private String email;
	@Column
	private long mobile;

}
