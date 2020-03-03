package com.wirecard.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wirecard.model.Order;
import com.wirecard.repositories.OrdersRepository;

@Repository
public class OrdersRepositoryImpl implements OrdersRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Order> findAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Orders").getResultList();
	}

	public Order getById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		return session.get(Order.class, id);
	}

	public void save(Order orders) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orders);
	}

}
