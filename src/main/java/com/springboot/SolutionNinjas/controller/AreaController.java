package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Area;
import com.springboot.SolutionNinjas.service.AreaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/","https://d2sedfhgvk3bdp.cloudfront.net/"})
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/areas")
    public ResponseEntity<List<Area>> getAreas() {
        return new ResponseEntity<List<Area>>(areaService.getAreas(), HttpStatus.OK);
    }

    @GetMapping("/areas/{zipcode}")
    public ResponseEntity<Area> getArea(@PathVariable String zipcode) {
        return new ResponseEntity<Area>(areaService.getOneArea(zipcode),HttpStatus.OK);
    }

    @DeleteMapping("/areas")
    public String deleteArea(@RequestParam String zipcode) {
        areaService.deleteArea(zipcode);
        return "Area having zipcode : "+zipcode+" has been deleted successfully.";
    }

    @PostMapping("/areas")
    public ResponseEntity<Area> insertArea(@Valid @RequestBody Area area) {
        return new ResponseEntity<Area>(areaService.insertArea(area),HttpStatus.CREATED);
    }

    @PutMapping("/areas/{zipcode}")
    public ResponseEntity<Area> updateArea(@PathVariable String zipcode,@RequestBody Area area ) {
        area.setZipcode(zipcode);
        return new ResponseEntity<Area>(areaService.updateArea(area),HttpStatus.OK);
    }
}
