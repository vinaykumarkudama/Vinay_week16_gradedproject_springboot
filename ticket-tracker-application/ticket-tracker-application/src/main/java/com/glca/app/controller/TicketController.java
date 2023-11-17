package com.glca.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glca.app.entity.Ticket;
import com.glca.app.service.ITicketService;

@Controller
public class TicketController {

	@Autowired
	private ITicketService ticketService;

	@RequestMapping("/")
	public String listOfTickets(Model model) {
		List<Ticket> ticketList = ticketService.getAllTickets();
		System.out.println(ticketList);
		model.addAttribute("tickets", ticketList);
		return "list-of-tickets";
	}

	@GetMapping("/create")
	public String showTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "create-ticket";
	}

	@PostMapping("/create")
	public String createTicket(@ModelAttribute Ticket ticket) {
		ticketService.addTicket(ticket);
		return "redirect:/listOfTickets";
	}

	@RequestMapping("/listOfTickets")
	public String listOfTicket(Model model) {
		List<Ticket> ticketList = ticketService.getAllTickets();
		model.addAttribute("tickets", ticketList);
		return "list-of-tickets";
	}

	@RequestMapping("/showUpdateForm")
	public String showupdateForm(@RequestParam("id") int tid, Model model) {
		Ticket ticketDetail = ticketService.getTicket(tid);
		model.addAttribute("ticket", ticketDetail);
		return "update-ticket";
	}

	@RequestMapping("/updateTicket")
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket) {

		ticketService.updateTicket(ticket);

		return "redirect:/listOfTickets";
	}

	@RequestMapping("/deleteTicket")
	public String deleteTicket(@RequestParam("id") int ticketId) {

		ticketService.deleteTicket(ticketId);

		return "redirect:/listOfTickets";
	}

	@RequestMapping("/showTicket")
	public String viewTicket(@RequestParam("id") int ticketId, Model model) {
		Ticket ticket = ticketService.getTicket(ticketId);
		model.addAttribute("ticket", ticket);
		return "view-ticket";
	}

	@GetMapping("/search")
	public String searchTicketsByName(@RequestParam("name") String name, Model model) {
		List<Ticket> searchResults = ticketService.searchTicketsByName(name);
		model.addAttribute("searchResults", searchResults);
		return "search";
	}

	@GetMapping("/ticket")
	public String viewTickets(Model model) {
		List<Ticket> ticketList = ticketService.getAllTickets();
		model.addAttribute("tickets", ticketList);
		return "tickets";
	}

}
