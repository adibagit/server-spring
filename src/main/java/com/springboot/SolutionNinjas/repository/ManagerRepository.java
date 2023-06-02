package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.model.Department;
import com.springboot.SolutionNinjas.model.User;
import com.springboot.SolutionNinjas.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Manager;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    List<Manager> findAllByUser(User userid);
}
