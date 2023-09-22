package com.maryam.SpringCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maryam.SpringCrud.exception.ResourceNotFoundException;
import com.maryam.SpringCrud.model.Product;
import com.maryam.SpringCrud.repository.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return this.productRepo.findAll();
	}
	
	
	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		Optional<Product> productDb = this.productRepo.findById(productId);
		if(productDb.isPresent()) {
			return productDb.get();
		}else {
			throw new ResourceNotFoundException("Record Not Found with id: " + productId);
		}
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> productDb = this.productRepo.findById(product.getProdId());
		if(productDb.isPresent()) {
			Product updateProduct = productDb.get();
			updateProduct.setProdId(product.getProdId());
			updateProduct.setProdName(product.getProdName());
			updateProduct.setPrice(product.getPrice());
			productRepo.save(updateProduct);
			return updateProduct;
		}else {
			throw new ResourceNotFoundException("Record Not Found with id: " + product.getProdId());
		}
		
	}

	@Override
	public void deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		Optional<Product> productDb = this.productRepo.findById(productId);
		if(productDb.isPresent()) {
			this.productRepo.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Record Not Found with id: " + productId);
		}
		
		
	}

}
