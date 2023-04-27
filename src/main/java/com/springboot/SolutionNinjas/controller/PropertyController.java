package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Property;
import com.springboot.SolutionNinjas.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getProperties() {
        return new ResponseEntity<List<Property>>(propertyService.getProperties(), HttpStatus.OK);
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity<Property> getProperty(@PathVariable int id) {
        return new ResponseEntity<Property>(propertyService.getOneProperty(id),HttpStatus.OK);
    }

    @DeleteMapping("/properties")
    public String deleteProperty(@RequestParam int id) {
        propertyService.deleteProperty(id);
        return "Property having zipcode : "+id+" has been deleted successfully.";
    }

    @PostMapping("/properties")
    public ResponseEntity<Property> insertProperty(@Valid @RequestBody Property property) {
        return new ResponseEntity<Property>(propertyService.insertProperty(property),HttpStatus.CREATED);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable int id,@RequestBody Property property ) {
        property.setPropertyid(id);
        return new ResponseEntity<Property>(propertyService.updateProperty(property),HttpStatus.OK);
    }

}
