package com.springboot.SolutionNinjas.model;

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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Entity
@Table(name="feedbacks")
public class Feedback {
	
	@Column(name="feedback_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackid;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

	@Column(name="feedback_description")
	private String feedbackdesc;
	
	@CreationTimestamp
	@Column(name="feedback_date", nullable=false, updatable=false)
	private Date feedbackdate;
	
	@UpdateTimestamp
	@Column(name="last_modified")
	private Date lastmodified;
	
	
}
