package com.ri.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.ri.util.CustomGenerator;

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
			strategy="com.ri.util.CustomGenerator",
			parameters= {
					 @Parameter(name=CustomGenerator.INCREMENT_PARAM, value = "1"),
					 @Parameter(name=CustomGenerator.VALUE_PREFIX_DEFAULT,value = "RI_"),
					 @Parameter(name=CustomGenerator.NUMBER_FORMAT_PARAMETER,value = "%5d")
			}
			)
	private String employeeid;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String gender;
	@Column(unique = true)
	private String email;
	@Column
	private long mobile;
	@Column
	private Integer deptno;

}
