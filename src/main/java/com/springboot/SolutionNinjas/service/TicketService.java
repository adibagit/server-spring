package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.repository.TicketRepository;

@Service
public class TicketService{

	@Autowired
	private TicketRepository ticketrepo;
	
	public List<Ticket> getTickets() {
		return ticketrepo.findAll();
	}

	public Ticket insertTicket(Ticket ticket) {
		return ticketrepo.save(ticket);
	}

	public Ticket getOneTicket(int ticketId) {
		Optional<Ticket> optionalTicket = ticketrepo.findById(ticketId);
		if(optionalTicket.isPresent())
			return optionalTicket.get();
		System.out.println("Ticket not found for id : "+ticketId);
		return null;
	}

	public void deleteTicket(int ticketId) {
		ticketrepo.deleteById(ticketId);
	}

	public Ticket updateTicket(Ticket ticket) {
		return ticketrepo.save(ticket);
	}

}
