package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.dto.LogsDto;
import com.springboot.SolutionNinjas.model.Log;
import com.springboot.SolutionNinjas.service.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/log")
    public ResponseEntity<List<Log>> getLogs() {
        return new ResponseEntity<List<Log>>(logService.getLogs(), HttpStatus.OK);
    }

    @GetMapping("/log/{id}")
    public ResponseEntity<Log> getLog(@PathVariable int id) {
        return new ResponseEntity<Log>(logService.getOneLog(id),HttpStatus.OK);
    }

    @DeleteMapping("/log")
    public String deleteLog(@RequestParam int id) {
        logService.deleteLog(id);
        return "Log having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/log")
    public ResponseEntity<Log> insertLog(@Valid @RequestBody Log log) {
        return new ResponseEntity<Log>(logService.insertLog(log),HttpStatus.CREATED);
    }

    @PutMapping("/log/{id}")
    public ResponseEntity<Log> updateLog(@PathVariable int id,@RequestBody Log log ) {
        log.setLogid(id);
        return new ResponseEntity<Log>(logService.updateLog(log),HttpStatus.OK);
    }

    @GetMapping("/logsByTicket/{ticketId}")
    public List<LogsDto> getLogsByTicket(@PathVariable int ticketId) {
        return logService.logsByTicketId(ticketId);
    }

    @GetMapping("/logsByDepartment/{departmentId}")
    public List<LogsDto> getLogsByDepartment(@PathVariable int departmentId) {
        return logService.logsByDepartmentId(departmentId);
    }
}
