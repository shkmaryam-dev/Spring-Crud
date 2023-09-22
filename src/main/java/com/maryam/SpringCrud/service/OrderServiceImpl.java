package com.maryam.SpringCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maryam.SpringCrud.exception.ResourceNotFoundException;
import com.maryam.SpringCrud.model.Customer;
import com.maryam.SpringCrud.model.OrderAccept;
import com.maryam.SpringCrud.model.OrderProd;
import com.maryam.SpringCrud.model.Product;
import com.maryam.SpringCrud.repository.CustomerRepo;
import com.maryam.SpringCrud.repository.OrderRepo;
import com.maryam.SpringCrud.repository.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<OrderProd> getAllOrders() {
		return this.orderRepo.findAll();
	}

	@Override
	public OrderProd getOrderById(Integer orderId) {
		Optional<OrderProd> orderDb = this.orderRepo.findById(orderId);

		if (orderDb.isPresent()) {
			return orderDb.get();
		} else {
			throw new ResourceNotFoundException("Record Not Found with id: " + orderId);
		}
	}

	@Override
	public OrderProd createOrder(OrderAccept order) {
		// TODO Auto-generated method stub
		Customer customer = customerRepo.findById(order.getCustId()).orElseThrow();
		Product product = productRepo.findById(order.getProdId()).orElseThrow();
		OrderProd addOrder = new OrderProd();

		addOrder.setCustId(customer);
		addOrder.setProdId(product);
		addOrder.setQty(order.getQty());
		addOrder.setTotal(order.getQty() * product.getPrice());
		orderRepo.save(addOrder);
		return addOrder;
	}

	@Override
	public OrderProd updateOrder(OrderProd order) {
		Optional<OrderProd> orderDb = this.orderRepo.findById(order.getOrderId());
		Product product = productRepo.findById(order.getProdId().getProdId()).orElseThrow();

		if (orderDb.isPresent()) {
			OrderProd updateOrder = orderDb.get();
			updateOrder.setCustId(order.getCustId());
			updateOrder.setProdId(order.getProdId());
			updateOrder.setQty(order.getQty());
			updateOrder.setTotal(order.getQty() * product.getPrice());
			orderRepo.save(updateOrder);
			return updateOrder;
		} else {
			throw new ResourceNotFoundException("Record Not Found with id: " + order.getOrderId());
		}
	}

	@Override
	public void deleteOrder(Integer orderId) {
		Optional<OrderProd> orderDb = this.orderRepo.findById(orderId);
		if (orderDb.isPresent()) {
			this.orderRepo.delete(orderDb.get());
		} else {
			throw new ResourceNotFoundException("Record Not Found with id: " + orderId);
		}

	}

	@Override
	public List<OrderProd> findOrderByCustId(Integer custId) {
		Customer customer = customerRepo.findById(custId).orElseThrow();
		// TODO Auto-generated method stub
		return this.orderRepo.findByCustId(customer);
	}

//	@Override
//	public List<OrderProd> findOrderByProdId(Integer ProdId) {
//		Product product = productRepo.findById(ProdId).orElseThrow();
//		Sort sort = Sort.by("total").ascending();
//		return this.orderRepo.findByProdId(product, sort);
//	}
	
	@Override
	public List<OrderProd> findOrderByProdId(Integer prodId) {
		Product product = this.productRepo.findById(prodId).orElseThrow();
		return this.orderRepo.findByProdId(product);
	}

	@Override
	public OrderProd getOrderDetailByMaxAmount() {
		// TODO Auto-generated method stub
		return this.orderRepo.findByMaxAmount();
	}

	@Override
	public OrderProd getOrderDetailByMinAmount() {
		// TODO Auto-generated method stub
		return this.orderRepo.findByMinAmount();
	}
}
