package com.springboot.SolutionNinjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
