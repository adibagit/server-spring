package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.AdminTicketsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Ticket;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT new com.springboot.SolutionNinjas.dto.AdminTicketsDTO(ticket.ticketid, user.emailid, ticket.description, property.propertyname, status.status, ticket.priority, ticket.ticketdate) "
            + "FROM Ticket ticket "
            + "INNER JOIN ticket.property property "
            + "INNER JOIN ticket.status status "
            + "INNER JOIN ticket.client user ")
    List<AdminTicketsDTO> ticketsReport();
}
