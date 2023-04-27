package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.City;
import com.springboot.SolutionNinjas.service.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<List<City>>(cityService.getCities(), HttpStatus.OK);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCity(@PathVariable int id) {
        return new ResponseEntity<City>(cityService.getOneCity(id),HttpStatus.OK);
    }

    @DeleteMapping("/cities")
    public String deleteCity(@RequestParam int id) {
        cityService.deleteCity(id);
        return "City having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/cities")
    public ResponseEntity<City> insertCity(@Valid @RequestBody City city) {
        return new ResponseEntity<City>(cityService.insertCity(city),HttpStatus.CREATED);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable int id,@RequestBody City city ) {
        city.setCityid(id);
        return new ResponseEntity<City>(cityService.updateCity(city),HttpStatus.OK);
    }
}
