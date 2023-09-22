package com.maryam.SpringCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maryam.SpringCrud.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

//	@Query(value = "")
	List<Customer> findByCustName(String custName);
}
