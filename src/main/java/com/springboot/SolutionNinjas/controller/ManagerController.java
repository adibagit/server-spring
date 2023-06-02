package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Manager;
import com.springboot.SolutionNinjas.model.User;
import com.springboot.SolutionNinjas.service.ManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/manager")
    public ResponseEntity<List<Manager>> getManagers() {
        return new ResponseEntity<List<Manager>>(managerService.getManagers(), HttpStatus.OK);
    }

    @GetMapping("/manager/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable int id) {
        return new ResponseEntity<Manager>(managerService.getOneManager(id),HttpStatus.OK);
    }

    @DeleteMapping("/manager")
    public String deleteManager(@RequestParam int id) {
        managerService.deleteManager(id);
        return "Manager having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/manager")
    public ResponseEntity<Manager> insertManager(@Valid @RequestBody Manager manager) {
        return new ResponseEntity<Manager>(managerService.insertManager(manager),HttpStatus.CREATED);
    }

    @PutMapping("/manager/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable int id,@RequestBody Manager manager ) {
        manager.setManagerid(id);
        return new ResponseEntity<Manager>(managerService.updateManager(manager),HttpStatus.OK);
    }

    @GetMapping("/managerByUser/{id}")
    public ResponseEntity<List<Manager>> getManagerByUser(@PathVariable User id) {
        return new ResponseEntity<List<Manager>>(managerService.getManagerByUser(id),HttpStatus.OK);
    }

}
