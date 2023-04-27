package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> getTickets() {
        return new ResponseEntity<List<Ticket>>(ticketService.getTickets(), HttpStatus.OK);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable int id) {
        return new ResponseEntity<Ticket>(ticketService.getOneTicket(id),HttpStatus.OK);
    }

    @DeleteMapping("/ticket")
    public String deleteTicket(@RequestParam int id) {
        ticketService.deleteTicket(id);
        return "Ticket having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> insertTicket(@Valid @RequestBody Ticket ticket) {
        return new ResponseEntity<Ticket>(ticketService.insertTicket(ticket),HttpStatus.CREATED);
    }

    @PutMapping("/ticket/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id,@RequestBody Ticket ticket ) {
        ticket.setTicketid(id);
        return new ResponseEntity<Ticket>(ticketService.updateTicket(ticket),HttpStatus.OK);
    }

}
