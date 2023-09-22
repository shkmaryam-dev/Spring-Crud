package com.maryam.SpringCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maryam.SpringCrud.model.Customer;
import com.maryam.SpringCrud.model.OrderProd;
import com.maryam.SpringCrud.model.Product;

@Repository
public interface OrderRepo extends JpaRepository<OrderProd, Integer>{
	
	List<OrderProd> findByCustId(Customer customer);
	
	@Query("SELECT o,p.prodName FROM OrderProd o LEFT JOIN Product p ON o.prodId = p.prodId WHERE o.prodId= :prodId ORDER BY o.total ASC")
	List<OrderProd> findByProdId(@Param("prodId") Product product);
	
//	List<OrderProd> findByProdId(Product product, Sort sort);
	
	@Query(value = "SELECT o FROM OrderProd o WHERE o.total = (SELECT MAX(order.total) FROM OrderProd as order)")
	OrderProd findByMaxAmount();
	
	@Query(value = "SELECT o FROM OrderProd o WHERE o.total = (SELECT MIN(order.total) FROM OrderProd as order)")
	OrderProd findByMinAmount();
}
