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

import com.maryam.SpringCrud.model.Customer;
import com.maryam.SpringCrud.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/Customers")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return ResponseEntity.ok().body(this.customerService.getAllCustomer());
	}

	@GetMapping("/Customers/{custId}")
	public ResponseEntity<Customer> getCustomerByCustId(@PathVariable Integer custId) {
		return ResponseEntity.ok().body(this.customerService.getCustomerById(custId));
	}

	@PostMapping("/Customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
	}

	@PutMapping("/Customers/{custId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer custId, @RequestBody Customer customer) {
		customer.setCustId(custId);
		return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
	}

	@DeleteMapping("/Customers/{custId}")
	public HttpStatus deleteCustomer(@PathVariable Integer custId) {
		this.customerService.deleteCustomer(custId);
		return HttpStatus.OK;
	}
	
}
