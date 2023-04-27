package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Country;
import com.springboot.SolutionNinjas.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getCountries() {
        return new ResponseEntity<List<Country>>(countryService.getCountries(), HttpStatus.OK);
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable int id) {
        return new ResponseEntity<Country>(countryService.getOneCountry(id),HttpStatus.OK);
    }

    @DeleteMapping("/countries")
    public String deleteCountry(@RequestParam int id) {
        countryService.deleteCountry(id);
        return "Country having id : "+id+" has been deleted successfully."; //OR HttpStatus.NO_CONTENT)
    }

    @PostMapping("/countries")
    public ResponseEntity<Country> insertCountry(@Valid @RequestBody Country country) {
        return new ResponseEntity<Country>(countryService.insertCountry(country),HttpStatus.CREATED);
    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable int id,@RequestBody Country country ) {
        country.setCountryid(id);
        return new ResponseEntity<Country>(countryService.updateCountry(country),HttpStatus.OK);
    }

}
