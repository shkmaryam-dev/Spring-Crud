package com.maryam.SpringCrud.service;

import java.util.List;

import com.maryam.SpringCrud.model.Customer;

public interface CustomerService {
	
	Customer createCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	List<Customer> getAllCustomer();

	Customer getCustomerById(Integer id);

	void deleteCustomer(Integer id);
}
