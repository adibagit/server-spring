package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.AdminTicketsDTO;
import com.springboot.SolutionNinjas.dto.TicketDto;
import com.springboot.SolutionNinjas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT t FROM Ticket t where t.client.userid=:userId")
    public List<Ticket> getTicketsByUser(@Param("userId") int userId);

    @Query("SELECT t FROM Ticket t where t.property.propertyid=:propertyId")
    public List<Ticket> getTicketsByProperty(@Param("propertyId") int propertyId);

    @Query("SELECT t FROM Ticket t where t.status.statusid=:statusId")
    public List<Ticket> getTicketsByStatus(@Param("statusId") int statusId);
}
