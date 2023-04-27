package com.springboot.SolutionNinjas.model;

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
@Table(name="countries")
public class Country {
	@Column(name="country_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryid;

	@NotBlank(message="Country name cannot be null")
	@Column(name="country_name")
	private String countryname; 
	
}
