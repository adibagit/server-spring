package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Feedback;
import com.springboot.SolutionNinjas.repository.FeedbackRespository;

@Service
public class FeedbackService{

	@Autowired
	private FeedbackRespository feedrepo;
	
	public List<Feedback> getFeedbacks() {
		return feedrepo.findAll();
	}

	public Feedback insertFeedback(Feedback feedback) {
		return feedrepo.save(feedback);
	}

	public Feedback getOneFeedback(int feedbackId) {
		Optional<Feedback> optionalFeedback = feedrepo.findById(feedbackId);
		if(optionalFeedback.isPresent())
			return optionalFeedback.get();
		System.out.println("Feedback not found for id : "+feedbackId);
		return null;
	}

	public void deleteFeedback(int feedbackId) {
		feedrepo.deleteById(feedbackId);
	}

	public Feedback updateFeedback(Feedback feedback) {
		return feedrepo.save(feedback);
	}

}
