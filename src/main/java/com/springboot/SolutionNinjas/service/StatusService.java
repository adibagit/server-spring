package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Status;
import com.springboot.SolutionNinjas.repository.StatusesRepository;

@Service
public class StatusService{

	@Autowired
	private StatusesRepository statusrepo;
	
	public List<Status> getStatuses() {
		return statusrepo.findAll();
	}

	public Status insertStatus(Status status) {
		return statusrepo.save(status);
	}

	public Status getOneStatus(int statusId) {
		Optional<Status> optionalStatus = statusrepo.findById(statusId);
		if(optionalStatus.isPresent())
			return optionalStatus.get();
		System.out.println("Status not found for id : "+statusId);
		return null;
	}

	public void deleteStatus(int statusId) {
		statusrepo.deleteById(statusId);
	}

	public Status updateStatus(Status status) {
		return statusrepo.save(status);
	}

}
