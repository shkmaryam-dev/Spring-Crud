package com.maryam.SpringCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maryam.SpringCrud.exception.ResourceNotFoundException;
import com.maryam.SpringCrud.model.Customer;
import com.maryam.SpringCrud.repository.CustomerRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> customerdb = this.customerRepo.findById(customer.getCustId());
		if (customerdb.isPresent()) {
			Customer updateCustomer = customerdb.get();
			updateCustomer.setCustId(customer.getCustId());
			updateCustomer.setCustName(customer.getCustName());
			updateCustomer.setAddress(customer.getAddress());
			customerRepo.save(updateCustomer);
			return updateCustomer;
		} else {
			throw new ResourceNotFoundException("Record Not Found with id: " + customer.getCustId());
		}
		// TODO Auto-generated method stub
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return this.customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> customerdb = this.customerRepo.findById(id);

		if (customerdb.isPresent()) {
			return customerdb.get();
		} else {
			throw new ResourceNotFoundException("Record Not Found with id: " + id);
		}

		// TODO Auto-generated method stub
	}

	@Override
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method
		Optional<Customer> customerdb = this.customerRepo.findById(id);

		if (customerdb.isPresent()) {
			this.customerRepo.delete(customerdb.get());
		} else {
			throw new ResourceNotFoundException("Record Not Found with id: " + id);
		}

	}

}
