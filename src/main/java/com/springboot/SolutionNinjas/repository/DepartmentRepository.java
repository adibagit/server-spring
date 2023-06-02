package com.springboot.SolutionNinjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
