package com.wirecard.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wirecard.model.Order;
import com.wirecard.repositories.OrdersRepository;
import com.wirecard.services.OrdersService;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersRepository ordersRepo;
	
	public List<Order> findAllOrders() {
		
		return ordersRepo.findAllOrders();
	}

	public Order getById(int id) {

		return ordersRepo.getById(id);
	}

	public void save(Order orders) {
		ordersRepo.save(orders);
	}

}
