package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import com.springboot.SolutionNinjas.dto.LogsDto;
import com.springboot.SolutionNinjas.exception.ResourceNotFoundException;
import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.model.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Log;
import com.springboot.SolutionNinjas.repository.LogRepository;

@Service
public class LogService {
	
	@Autowired
	private LogRepository logRepo;
	
	public List<Log> getLogs() {
		return logRepo.findAll();
	}

	public Log insertLog(Log log) {
		return logRepo.save(log);
	}

	public Log getOneLog(int logId) {
		Optional<Log> optionalLog = Optional.ofNullable(logRepo.findById(logId).orElseThrow(() -> new ResourceNotFoundException("Log", "Id", logId)));
		if(optionalLog.isPresent())
			return optionalLog.get();
		System.out.println("User not found for id: "+logId);
		return null;
	}

	public void deleteLog(int logId) {
		logRepo.deleteById(logId);
	}
	
	public Log updateLog(Log log) {
		return logRepo.save(log);
	}

	public List<LogsDto> logsByWorkflowId(int workflowId) {
		return logRepo.getLogsByWorkflow(workflowId);
	}

	public List<LogsDto> logsByDepartmentId(int departmentId) {
		return logRepo.getLogsByDepartment(departmentId);
	}

	public Boolean isWorkflowAssigned(Workflow id){ return logRepo.isWorkflowAssigned(id);}

    public List<Log> getLogsByEmployee(int empId, int statusId) {
		return logRepo.getLogsByEmp(empId,statusId);
    }
}
