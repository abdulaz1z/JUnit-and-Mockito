package com.aziz.dao;

import java.sql.SQLException;

import com.aziz.dto.Order;

public interface OrderDAO {
	public int create(Order order) throws SQLException;
	public Order read(int id) throws SQLException;
	public int update(Order order) throws SQLException;
	public int delete(int id) throws SQLException;
}