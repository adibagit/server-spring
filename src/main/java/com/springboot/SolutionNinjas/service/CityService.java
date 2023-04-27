package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.City;
import com.springboot.SolutionNinjas.repository.CityRepository;

@Service
public class CityService{
	
	@Autowired
	private CityRepository cityrepo;

	public List<City> getCities() {
		return cityrepo.findAll();
	}

	public City insertCity(City c) {
		return cityrepo.save(c);
	}

	public City getOneCity(int id) {
		Optional<City> c = cityrepo.findById(id);
		if(c.isPresent())
			return c.get();
		System.out.println("Department not found for id : "+id);
		return null;
	}

	public void deleteCity(int id) {
		cityrepo.deleteById(id);
	}

	public City updateCity(City c) {
		return cityrepo.save(c);
	}

}
