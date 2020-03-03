package com.wirecard.services;

import java.util.List;

import com.wirecard.model.Product;

public interface ProductService {

	public List<Product> findAllProduct();
	public Product getById(int id);
	public void save(Product product);
}
