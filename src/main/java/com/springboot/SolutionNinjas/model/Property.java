package com.springboot.SolutionNinjas.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Entity
@Table(name="properties")
public class Property {

	@Column(name="property_id")
	@Id
	private int propertyid;
	
	@NotBlank(message="Property name cannot be null")
	@Column(name="property_name")
	private String propertyname;
	
	@Column(name = "property_description")
    private String propertydesc;
	
	@Column(name = "property_address")
    private String propertyaddress;
	
	@ManyToOne
    @JoinColumn(name = "zip_code")
    private Area area;
	
	@CreationTimestamp
	@Column(name="reg_date", nullable=false, updatable=false)
	private Date regdate;
	
	@UpdateTimestamp
	@Column(name="last_modified")
	private Date lastmodified;
	
    
}
