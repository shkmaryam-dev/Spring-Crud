package com.maryam.SpringCrud.service;

import java.util.List;

import com.maryam.SpringCrud.model.Product;

public interface ProductService {
	
	List<Product> getAllProduct();

	Product getProductById(Integer productId);

	Product createProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Integer productId);
}
