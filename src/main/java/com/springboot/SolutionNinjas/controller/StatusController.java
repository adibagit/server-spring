package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Status;
import com.springboot.SolutionNinjas.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping("/status")
    public ResponseEntity<List<Status>> getStatus() {
        return new ResponseEntity<List<Status>>(statusService.getStatuses(), HttpStatus.OK);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<Status> getStatus(@PathVariable int id) {
        return new ResponseEntity<Status>(statusService.getOneStatus(id),HttpStatus.OK);
    }

    @DeleteMapping("/status")
    public String deleteStatus(@RequestParam int id) {
        statusService.deleteStatus(id);
        return "Status having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/status")
    public ResponseEntity<Status> insertStatus(@Valid @RequestBody Status status) {
        return new ResponseEntity<Status>(statusService.insertStatus(status),HttpStatus.CREATED);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable int id,@RequestBody Status status ) {
        status.setStatusid(id);
        return new ResponseEntity<Status>(statusService.updateStatus(status),HttpStatus.OK);
    }
}
