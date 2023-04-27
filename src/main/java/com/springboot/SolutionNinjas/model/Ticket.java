package com.springboot.SolutionNinjas.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="tickets")
public class Ticket {

	@Column(name="ticket_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketid;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
	
	@NotBlank(message="Please enter problem description!")
	@Column(name="ticket_description")
	private String description;
	
	@ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
        
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
	
	private int priority;
	    
    @CreationTimestamp
	@Column(name="ticket_date", nullable=false, updatable=false)
	private Date ticketdate;
	
	@UpdateTimestamp
	@Column(name="last_modified")
	private Date lastmodified;
   
}
