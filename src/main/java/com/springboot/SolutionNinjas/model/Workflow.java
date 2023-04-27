package com.springboot.SolutionNinjas.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="workflows")
public class Workflow {

	@Column(name="workflow_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workflowid;
	
	@ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
	
	@ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
	
	@ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;	
	
	private String description;
	
	private int priority;
	
	@CreationTimestamp
	@Column(name="created_date", nullable=false, updatable=false)
	private Date date;
	
}
