package com.glca.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glca.app.entity.Ticket;
import com.glca.app.repository.ITicketRepository;

@Service
public class ITicketServiceImpl implements ITicketService {

	@Autowired
	private ITicketRepository ticketRepository;

	@Override
	public Ticket addTicket(Ticket ticket) {
		Ticket t = ticketRepository.save(ticket);
		return t;
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		Ticket t = getTicket(ticket.getId());
		t.setTitle(ticket.getTitle());
		t.setShortDescription(ticket.getShortDescription());
		t.setCreatedDate(ticket.getCreatedDate());
		ticketRepository.save(t);
		return t;
	}

	@Override
	public boolean deleteTicket(int id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
		return true;
	}

	@Override
	public Ticket getTicket(int id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id).get();
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		List<Ticket> tickets = ticketRepository.findAll();
		return tickets;
	}

	@Override
	public List<Ticket> searchTicketsByName(String name) {

		return ticketRepository.searchTicketsByName(name);
	}

}
