package com.springboot.SolutionNinjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
