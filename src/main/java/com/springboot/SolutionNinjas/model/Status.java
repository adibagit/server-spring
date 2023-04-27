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

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="status")
public class Status {
	@Column(name="status_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusid;
	
	@NotBlank(message="First name cannot be null")
	private String status;
}
