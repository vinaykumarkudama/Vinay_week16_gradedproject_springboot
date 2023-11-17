package com.glca.app.service;

import java.util.List;

import com.glca.app.entity.Ticket;

public interface ITicketService {

	public Ticket addTicket(Ticket ticket);

	public Ticket updateTicket(Ticket ticket);

	public boolean deleteTicket(int id);

	public Ticket getTicket(int id);

	public List<Ticket> getAllTickets();

	public List<Ticket> searchTicketsByName(String name);

}
