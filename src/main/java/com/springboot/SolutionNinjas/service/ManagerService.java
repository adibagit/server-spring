package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import com.springboot.SolutionNinjas.exception.ResourceNotFoundException;
import com.springboot.SolutionNinjas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Manager;
import com.springboot.SolutionNinjas.repository.ManagerRepository;

@Service
public class ManagerService{

	@Autowired
	private ManagerRepository managerrepo;
	
	public List<Manager> getManagers() {
		return managerrepo.findAll();
	}

	public Manager insertManager(Manager manager) {
		return managerrepo.save(manager);
	}

	public Manager getOneManager(int managerId) {
		Optional<Manager> optionalManager = Optional.ofNullable(managerrepo.findById(managerId).orElseThrow(() -> new ResourceNotFoundException("Manager", "Id", managerId)));
		if(optionalManager.isPresent())
			return optionalManager.get();
		System.out.println("Manager not found for id : "+managerId);
		return null;
	}

	public void deleteManager(int managerId) {
		managerrepo.deleteById(managerId);
	}

	public Manager updateManager(Manager manager) {
		return managerrepo.save(manager);
	}

	public List<Manager> getManagerByUser(User userId) {
		return managerrepo.findAllByUser(userId);
	}

}
