package com.ri.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable{
	@Id
	@GeneratedValue
	private Integer deptno;
	@Column
	private String deptname;
	@Column
	private String location;
	@Column
	private String head;

}
