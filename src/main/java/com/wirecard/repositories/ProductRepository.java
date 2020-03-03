package com.wirecard.repositories;

import java.util.List;

import com.wirecard.model.Product;

public interface ProductRepository {

	public List<Product> findAllProduct();
	public Product getById(int id);
	public void save(Product product);
}
