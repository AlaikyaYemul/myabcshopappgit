package com.abcshopapp.dao;

import java.util.List;

import com.abcshopapp.dto.Product;

public interface ProductDao {
	
	void save(Product product); // insert
	
	Product findById(int productId); // select
	
	List<Product> findAll();

}
