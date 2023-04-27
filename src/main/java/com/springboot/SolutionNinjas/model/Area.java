package com.springboot.SolutionNinjas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Entity
@Table(name="areas")
public class Area {
	
	@Column(name="zip_code")
	@Id
	private String zipcode;
	
	@NotBlank(message="Area name cannot be null")
	@Column(name="area_name")
	private String areaname;
	
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
