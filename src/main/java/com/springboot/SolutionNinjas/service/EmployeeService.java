package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Employee;
import com.springboot.SolutionNinjas.repository.EmployeeRepository;

@Service
public class EmployeeService{
	
	@Autowired
	private EmployeeRepository emprepo;
	
	public List<Employee> getEmployee() {
		return emprepo.findAll();
	}

	public Employee insertEmployee(Employee employee) {
		return emprepo.save(employee);
	}

	public Employee getOneEmployee(int empId) {
		Optional<Employee> optionalEmployee = emprepo.findById(empId);
		if(optionalEmployee.isPresent())
			return optionalEmployee.get();
		System.out.println("Employee not found for id : "+empId);
		return null;
	}

	public void deleteEmployee(int empId) {
		emprepo.deleteById(empId);
	}

	public Employee updateEmployee(Employee employee) {
		return emprepo.save(employee);
	}

}
