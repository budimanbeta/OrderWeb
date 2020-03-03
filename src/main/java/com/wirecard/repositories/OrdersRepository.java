package com.wirecard.repositories;

import java.util.List;

import com.wirecard.model.Order;

public interface OrdersRepository {

	public List<Order> findAllOrders();
	public Order getById(int id);
	public void save(Order orders);
	
}
