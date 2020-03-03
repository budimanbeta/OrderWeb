package com.wirecard.services;

import java.util.List;

import com.wirecard.model.Order;

public interface OrdersService {

	public List<Order> findAllOrders();
	public Order getById(int id);
	public void save(Order orders);
	
}
