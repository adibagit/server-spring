package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Country;
import com.springboot.SolutionNinjas.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository crepo;
	
	public List<Country> getCountries() {
		return crepo.findAll();
	}

	public Country insertCountry(Country c) {
		return crepo.save(c);
	}

	public Country getOneCountry(int id) {
		Optional<Country> c = crepo.findById(id);
		if(c.isPresent())
			return c.get();
		System.out.println("\"Country not found for id"+id);
		return null;
	}

	public void deleteCountry(int id) {
		crepo.deleteById(id);
	}

	public Country updateCountry(Country c) {
		return crepo.save(c);
	}

}
