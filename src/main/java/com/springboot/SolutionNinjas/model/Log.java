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
@Table(name="logs")
public class Log {
	
	@Column(name="log_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int logid;
	
	@ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;
	
	@ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
	
	@ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
	
	private String comment;
	
    @CreationTimestamp
	@Column(name="activity_date", nullable=false, updatable=false)
	private Date logdate;
	
}
