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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Entity
@Table(name="images")
public class Image {
	
	@Column(name="image_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageid;
	
	@Column(name="image_name")
	private String imagename;
	
	@Column(name="image_path")
	private String imagepath;
		
	@ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id", insertable = false, updatable = false)
    private Ticket ticket;

}
