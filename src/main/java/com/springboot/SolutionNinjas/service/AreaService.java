package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Area;
import com.springboot.SolutionNinjas.repository.AreaRepository;

@Service
public class AreaService {

	@Autowired
	private AreaRepository arepo;

	public List<Area> getAreas() {
		return arepo.findAll();
	}

	public Area insertArea(Area a) {
		return arepo.save(a);
	}

	public Area getOneArea(String zipcode) {
		Optional<Area> a = arepo.findById(zipcode);
		if(a.isPresent())
			return a.get();
		System.out.println("Area not found for zipcode : "+zipcode);
		return null;
	}

	public void deleteArea(String zipcode) {
		arepo.deleteById(zipcode);
	}
	public Area updateArea(Area a) {
		return arepo.save(a);
	}

}
