package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import com.springboot.SolutionNinjas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Department;
import com.springboot.SolutionNinjas.repository.DepartmentRepository;

@Service
public class DepartmentService{

	@Autowired
	private DepartmentRepository drepo;
	
	public List<Department> getDepartments() {
		return drepo.findAll();
	}

	public Department insertDepartment(Department d) {
		return drepo.save(d);
	}

	public Department getOneDepartment(int id) {
		Optional<Department> d = Optional.ofNullable(drepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id)));
		if(d.isPresent())
			return d.get();
		System.out.println("Department not found for id : "+id);
		return null;
	}

	public void deleteDepartment(int id) {
		drepo.deleteById(id);
	}

	public Department updateDepartment(Department d) {
		return drepo.save(d);
	}

	public List<Department> getDepartmentsWithoutManager() {
		return drepo.getDepartmentWithoutManager();
	}

    public int getDeptByEmpId(int userId) {
		return drepo.getDepart(userId);
    }
}
