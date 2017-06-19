package com.FirstSpringProject.dao;

import com.FirstSpringProject.model.Product;

import java.util.List;

/**
 * Created by sicluceatlux on 2017-03-12.
 */

public interface ProductDao {
	
	List<Product> getProductList();
	Product getProductById(int id);
	void addProduct(Product product);
	void editProduct(Product product);
	void deleteProduct(Product product);
}

