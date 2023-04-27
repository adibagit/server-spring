package com.springboot.SolutionNinjas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="cities")
public class City {
	
	@Column(name="city_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityid;
	
	@NotBlank(message="Country name cannot be null")
	@Column(name="city_name")
	private String cityname;

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "country_id")
    private Country country;
	
}
