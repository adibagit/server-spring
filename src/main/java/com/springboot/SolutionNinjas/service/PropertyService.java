package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import com.springboot.SolutionNinjas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Property;
import com.springboot.SolutionNinjas.repository.PropertyRepository;

@Service
public class PropertyService{

	@Autowired
	private PropertyRepository prepo;
	
	public List<Property> getProperties() {
		return prepo.findAll();
	}

	public Property insertProperty(Property p) {
		return prepo.save(p);
	}

	public Property getOneProperty(int pid) {
		Optional<Property> p = Optional.ofNullable(prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Property", "Id", pid)));
		if(p.isPresent())
			return p.get();
		System.out.println("Property not found for id"+pid);
		return null;
	}

	public void deleteProperty(int pid) {
		prepo.deleteById(pid);
	}

	public Property updateProperty(Property p) {
		return prepo.save(p);
	}

}
