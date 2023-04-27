package com.springboot.SolutionNinjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
