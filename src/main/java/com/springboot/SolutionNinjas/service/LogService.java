package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

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
		Optional<Log> optionalLog = logRepo.findById(logId);
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
}
