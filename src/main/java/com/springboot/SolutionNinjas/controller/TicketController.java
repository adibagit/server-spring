package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.dto.TicketDto;
import com.springboot.SolutionNinjas.exception.ResourceNotFoundException;
import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.service.ImageService;
import com.springboot.SolutionNinjas.service.TicketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/","https://d2sedfhgvk3bdp.cloudfront.net/"})
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> getTickets() {
        return new ResponseEntity<List<Ticket>>(ticketService.getTickets(), HttpStatus.OK);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable @NotNull int id) {
        return new ResponseEntity<Ticket>(ticketService.getOneTicket(id),HttpStatus.OK);
    }

    @DeleteMapping("/ticket")
    public String deleteTicket(@RequestParam int id) {
        //imageService.deleteImageByTicket(id); //Instead, set cascade delete hehheh
        ticketService.deleteTicket(id);
        return "Ticket having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> insertTicket(@Valid @RequestBody Ticket ticket) {
        return new ResponseEntity<Ticket>(ticketService.    insertTicket(ticket),HttpStatus.CREATED);
    }

    @PutMapping("/ticket/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id,@RequestBody Ticket ticket ) {
        ticket.setTicketid(id);
        return new ResponseEntity<Ticket>(ticketService.updateTicket(ticket),HttpStatus.OK);
    }

    @GetMapping("/getTicketBy/{Id}/{fieldName}")
    public List<Ticket> allTicketsBy(@PathVariable int Id, @PathVariable String fieldName){
        switch (fieldName)
        {
            case "property": return ticketService.getTicketsByProperty(Id);
            case "user": return ticketService.getTicketsByUser(Id);
            case "status": return ticketService.getTicketsByStatus(Id);
            default:throw new ResourceNotFoundException("Tickets",fieldName,Id);
        }
    }

    @GetMapping("/getTicketByDepartment/{departmentId}")
    public List<TicketDto> allTicketsByDepartment(@PathVariable int departmentId){
        return ticketService.getTicketByDepartment(departmentId);
    }

    @PutMapping("/changeTicketStatus/{ticketId}/{statusId}")
    public String updateTicketStatus(@PathVariable int ticketId,@PathVariable int statusId) {
        ticketService.TicketStatusChange(ticketId,statusId);
        return "it works";
    }

}
