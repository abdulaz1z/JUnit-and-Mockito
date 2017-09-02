package com.aziz.bo;

import com.aziz.bo.exception.BOException;
import com.aziz.dto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;
	boolean cancelOrder(int id) throws BOException;
	boolean delete(int id) throws BOException;
	

}
