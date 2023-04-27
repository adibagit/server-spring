package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Feedback;
import com.springboot.SolutionNinjas.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("/feedback")
    public ResponseEntity<List<Feedback>> getFeedbacks() {
        return new ResponseEntity<List<Feedback>>(feedbackService.getFeedbacks(), HttpStatus.OK);
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedback(@PathVariable int id) {
        return new ResponseEntity<Feedback>(feedbackService.getOneFeedback(id),HttpStatus.OK);
    }

    @DeleteMapping("/feedback")
    public String deleteFeedback(@RequestParam int id) {
        feedbackService.deleteFeedback(id);
        return "Feedback having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/feedback")
    public ResponseEntity<Feedback> insertFeedback(@Valid @RequestBody Feedback feedback) {
        return new ResponseEntity<Feedback>(feedbackService.insertFeedback(feedback),HttpStatus.CREATED);
    }

    @PutMapping("/feedback/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable int id,@RequestBody Feedback feedback ) {
        feedback.setFeedbackid(id);
        return new ResponseEntity<Feedback>(feedbackService.updateFeedback(feedback),HttpStatus.OK);
    }

}
