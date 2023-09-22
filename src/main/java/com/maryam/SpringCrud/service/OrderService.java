package com.maryam.SpringCrud.service;

import java.util.List;

import com.maryam.SpringCrud.model.OrderAccept;
import com.maryam.SpringCrud.model.OrderProd;

public interface OrderService {

	List<OrderProd> getAllOrders();

	OrderProd getOrderById(Integer orderId);

	OrderProd createOrder(OrderAccept order);

	OrderProd updateOrder(OrderProd order);

	void deleteOrder(Integer orderId);

	List<OrderProd> findOrderByCustId(Integer custId);

	List<OrderProd> findOrderByProdId(Integer prodId);
	
	OrderProd getOrderDetailByMaxAmount();
	
	OrderProd getOrderDetailByMinAmount();

}
