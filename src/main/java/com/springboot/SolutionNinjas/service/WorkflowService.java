package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Workflow;
import com.springboot.SolutionNinjas.repository.WorkflowRepository;

@Service
public class WorkflowService {
	
	@Autowired
	private WorkflowRepository workflowRepo;
	
	public List<Workflow> getWorkflows() {
		return workflowRepo.findAll();
	}

	public Workflow insertWorkflow(Workflow workflow) {
		return workflowRepo.save(workflow);
	}

	public Workflow getOneWorkflow(int workflowId) {
		Optional<Workflow> optionalWorkflow = workflowRepo.findById(workflowId);
		if(optionalWorkflow.isPresent())
			return optionalWorkflow.get();
		System.out.println("Workflow not found for id: "+workflowId);
		return null;
	}

	public void deleteWorkflow(int workflowId) {
		workflowRepo.deleteById(workflowId);
	}
	
	public Workflow updateWorkflow(Workflow workflow) {
		return workflowRepo.save(workflow);
	}
}
