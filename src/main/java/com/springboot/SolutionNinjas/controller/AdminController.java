package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.config.CorsConfig;
import com.springboot.SolutionNinjas.dto.AdminTicketsDTO;
import com.springboot.SolutionNinjas.dto.AdminWorkflowsDTO;
import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/tickets")
    public ResponseEntity<List<AdminTicketsDTO>> getTicketsReport() {
        return new ResponseEntity<List<AdminTicketsDTO>>(adminService.getTicketsReport(), HttpStatus.OK);
    }

    @GetMapping("/workflows/{ticketid}")
    public ResponseEntity<List<AdminWorkflowsDTO>> getWorkflowsReport(@PathVariable Ticket ticketid) {
        return new ResponseEntity<List<AdminWorkflowsDTO>>(adminService.getWorkflowsReport(ticketid), HttpStatus.OK);
    }

    @GetMapping("/logs/{ticketid}")
    public ResponseEntity<List<AdminWorkflowsDTO>> getLogsReport(@PathVariable Ticket ticketid) {
       // return new ResponseEntity<List<AdminWorkflowsDTO>>(adminService.getWorkflowsReport(ticketid), HttpStatus.OK);
        return null;
    }
}
