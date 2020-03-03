package com.wirecard.repositories.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wirecard.model.Product;
import com.wirecard.repositories.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> findAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Product").getResultList();
	}

	public Product getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Product.class, id);
	}

	public void save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		int result = 0;
		
		session.save(product);
		System.out.println("Success Save");
				
//		return result;
	}

}
