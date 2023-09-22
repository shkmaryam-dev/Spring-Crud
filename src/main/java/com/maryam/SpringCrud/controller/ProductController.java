package com.maryam.SpringCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maryam.SpringCrud.model.Product;
import com.maryam.SpringCrud.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
		@GetMapping("/Products")
		public ResponseEntity<List<Product>> getAllProduct() {
			return ResponseEntity.ok().body(this.productService.getAllProduct());
		}

		@GetMapping("/Products/{proId}")
		public ResponseEntity<Product> getProductByProductId(@PathVariable Integer prodId) {
			return ResponseEntity.ok().body(this.productService.getProductById(prodId));
		}

		@PostMapping("/Products")
		public ResponseEntity<Product> createProduct(@RequestBody Product product) {
			return ResponseEntity.ok().body(this.productService.createProduct(product));
		}

		@PutMapping("/Products/{prodId}")
		public ResponseEntity<Product> updateProduct(@PathVariable Integer prodId, @RequestBody Product product) {
			product.setProdId(prodId);
			return ResponseEntity.ok().body(this.productService.updateProduct(product));
		}

		@DeleteMapping("/Products/{prodId}")
		public HttpStatus deleteProduct(@PathVariable Integer prodId) {
			this.productService.deleteProduct(prodId);
			return HttpStatus.OK;
		}
}
