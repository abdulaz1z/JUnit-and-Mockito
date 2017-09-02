package com.aziz.bo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.aziz.bo.exception.BOException;
import com.aziz.dao.OrderDAO;
import com.aziz.dto.Order;

public class OrderBOImplTest {
	
	@Mock
	OrderDAO dao;
	private OrderBOImpl bo;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	//------------------------- placeOrder()-----------------------------------------
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		
		//setting the expectation of the dependency of the function that i'm testing
		when(dao.create(order)).thenReturn(new Integer(1));
		
		boolean result = bo.placeOrder(order);
		assertTrue(result);
		
		//Verify method can be used to see if the stubbed method got called more than once.
		verify(dao).create(order);
	}
	
	@Test
	public void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));
		
		boolean result = bo.placeOrder(order);
		assertFalse(result);
		
		//Verify method can be used to see if the stubbed method got called more than once.
		verify(dao).create(order);
	}

	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		bo.placeOrder(order);
	}
	
	//-------------------------------------------------------------------------------------
	
	//------------------------- cancelOrder()-----------------------------------------
		@Test
		public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
			Order order = new Order();
			
			//setting the expectation of the dependency of the function that i'm testing
			when(dao.read(123)).thenReturn(order);
			when(dao.update(order)).thenReturn(1);
			
			boolean result = bo.cancelOrder(123);
			assertTrue(result);
			
			//Verify method can be used to see if the stubbed method got called more than once.
			verify(dao).read(123);
			verify(dao).update(order);
		}
		
		@Test
		public void cancelOrder_Should_Not_Cancel_The_Order() throws SQLException, BOException {
			Order order = new Order();
			when(dao.read(123)).thenReturn(order);
			when(dao.update(order)).thenReturn(0);
			
			boolean result = bo.cancelOrder(123);
			
			assertFalse(result);
			
			verify(dao).read(123);
			verify(dao).update(order);
		}
		
		@Test(expected = BOException.class)
		public void cancelOrder_Should_Throw_BOException_On_Read() throws SQLException, BOException {
			when(dao.read(123)).thenThrow(SQLException.class);
			bo.cancelOrder(123);
		}
		
		@Test(expected = BOException.class)
		public void cancelOrder_Should_Throw_BOException_On_Update() throws SQLException, BOException {
			Order order = new Order();
			when(dao.read(123)).thenReturn(order);
			when(dao.update(order)).thenThrow(SQLException.class);
			bo.cancelOrder(123);
		}
		
		//-------------------------------------------------------------------------------------
		
		//------------------------- delete()-----------------------------------------
		@Test
		public void delete_Should_Delete_An_Order() throws SQLException, BOException {
			Order order = new Order();
			
			//setting the expectation of the dependency of the function that i'm testing
			when(dao.delete(123)).thenReturn(new Integer(1));
			
			boolean result = bo.delete(123);
			assertTrue(result);
			
			//Verify method can be used to see if the stubbed method got called more than once.
			verify(dao).delete(123);
		}
		
		@Test
		public void delete_Should__Not_Delete_An_Order() throws SQLException, BOException {
			Order order = new Order();
			
			//setting the expectation of the dependency of the function that i'm testing
			when(dao.delete(123)).thenReturn(new Integer(0));
			
			boolean result = bo.delete(123);
			assertFalse(result);
			
			//Verify method can be used to see if the stubbed method got called more than once.
			verify(dao).delete(123);
		}

		@Test(expected = BOException.class)
		public void delete_Should_Throw_BOException() throws SQLException, BOException {
			when(dao.delete(123)).thenThrow(SQLException.class);
			bo.delete(123);
		}
		
		//-------------------------------------------------------------------------------------
		
}
