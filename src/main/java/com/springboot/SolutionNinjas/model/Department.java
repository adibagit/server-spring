package com.springboot.SolutionNinjas.model;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Entity
@Table(name="departments")
public class Department {
	@Column(name="dept_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptid;
	
	@NotBlank(message="Department name cannot be null")
	@Column(name="dept_name")
	private String deptname;
	
	@NotBlank(message="Please enter description of the department")
	@Column(name="dept_description")
	private String deptdesc; 
	 
	@UpdateTimestamp
	@Column(name="last_modified")
	private Date lastmodified;
}
