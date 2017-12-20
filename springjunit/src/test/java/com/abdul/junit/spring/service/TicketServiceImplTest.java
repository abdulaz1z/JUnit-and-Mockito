package com.abdul.junit.spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abdul.junit.spring.dao.TicketDAO;
import com.abdul.junit.spring.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {
	private static final String PASSANGER_NAME = "Abdul Aziz";
	private static final String PHONE = "1234567890";
	private static final int EXPECTED_RESULT = 1;
	
	@Mock
	TicketDAO dao;
	
	@Autowired
	@InjectMocks
	private TicketServiceImpl ticketServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buyTicketShouldReturnAValidValue() {
		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int result = ticketServiceImpl.buyTicket(PASSANGER_NAME, PHONE);
		assertEquals(EXPECTED_RESULT, result);
	}

}
