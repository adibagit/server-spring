package com.springboot.SolutionNinjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
}
