package com.springboot.SolutionNinjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Feedback;

@Repository
public interface FeedbackRespository extends JpaRepository<Feedback, Integer> {

}
