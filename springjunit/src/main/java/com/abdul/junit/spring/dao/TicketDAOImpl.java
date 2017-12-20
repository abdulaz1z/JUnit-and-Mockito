package com.abdul.junit.spring.dao;

import org.springframework.stereotype.Component;

import com.abdul.junit.spring.dto.Ticket;

@Component
public class TicketDAOImpl implements TicketDAO{

	public int createTicket(Ticket ticket) {
		return 1;
	}

}
