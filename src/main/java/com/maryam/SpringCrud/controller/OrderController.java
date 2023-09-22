package com.maryam.SpringCrud.controller;

import java.util.ArrayList;
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

import com.maryam.SpringCrud.model.DataTransfer;
import com.maryam.SpringCrud.model.OrderAccept;
import com.maryam.SpringCrud.model.OrderProd;
import com.maryam.SpringCrud.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/Orders")
	public ResponseEntity<List<DataTransfer>> getAllOrders() {
		List<OrderProd> orderlist = this.orderService.getAllOrders();
		List<DataTransfer> orderData = new ArrayList<DataTransfer>();
		for (OrderProd order : orderlist) {
			orderData.add(new DataTransfer(order.getOrderId(), order.getCustId().getCustName(),
					order.getProdId().getProdName(), order.getQty(), order.getProdId().getPrice(), order.getTotal()));
		}
		return ResponseEntity.ok().body(orderData);
	}

	@GetMapping("/Orders/{orderId}")
	public ResponseEntity<DataTransfer> getOrderById(@PathVariable Integer orderId) {
		OrderProd orderDetail = this.orderService.getOrderById(orderId);
		return ResponseEntity.ok()
				.body(new DataTransfer(orderDetail.getOrderId(), orderDetail.getCustId().getCustName(),
						orderDetail.getProdId().getProdName(), orderDetail.getQty(), orderDetail.getProdId().getPrice(),
						orderDetail.getTotal()));
	}

	@PostMapping("/Orders")
	public ResponseEntity<OrderProd> createOrder(@RequestBody OrderAccept order) {
		return ResponseEntity.ok().body(this.orderService.createOrder(order));
	}

	@PutMapping("/Orders/{orderId}")
	public ResponseEntity<OrderProd> updateOrder(@PathVariable Integer orderId, @RequestBody OrderProd order) {
		order.setOrderId(orderId);
		return ResponseEntity.ok().body(this.orderService.updateOrder(order));
	}

	@DeleteMapping("/Orders/{orderId}")
	public HttpStatus deleteOrder(@PathVariable Integer orderId) {
		this.orderService.deleteOrder(orderId);
		return HttpStatus.OK;
	}
	
	@GetMapping("/orderByCustomerId/{custId}")
	public ResponseEntity<List<DataTransfer>> getOrderDetailByCustomer(@PathVariable Integer custId) {
		List<OrderProd> orders = orderService.findOrderByCustId(custId);
		List<DataTransfer> orderData = new ArrayList<>();
		for (OrderProd order : orders) {
			orderData.add(new DataTransfer(order.getOrderId(), order.getCustId().getCustName(),
					order.getProdId().getProdName(), order.getQty(), order.getProdId().getPrice(), order.getTotal()));
		}
		return ResponseEntity.ok().body(orderData);
	}
	
	@GetMapping("/orderByProductId/{prodId}")
	public ResponseEntity<List<DataTransfer>> getOrderDetailByProduct(@PathVariable Integer prodId) {
		List<OrderProd> orders = orderService.findOrderByProdId(prodId);
		List<DataTransfer> orderData = new ArrayList<>();
		for (OrderProd order : orders) {
			orderData.add(new DataTransfer(order.getOrderId(), order.getCustId().getCustName(),
					order.getProdId().getProdName(), order.getQty(), order.getProdId().getPrice(), order.getTotal()));
		}
		return ResponseEntity.ok().body(orderData);
	}
	
	
	@GetMapping("/orderByMaxAmount")
	public ResponseEntity<DataTransfer> getOrderDetailByMaxAmount() {
		OrderProd orders = orderService.getOrderDetailByMaxAmount();
		return ResponseEntity.ok().body(new DataTransfer(orders.getOrderId(), orders.getCustId().getCustName(),
				orders.getProdId().getProdName(), orders.getQty(), orders.getProdId().getPrice(),
				orders.getTotal()));
	}
	
	@GetMapping("/orderByMinAmount")
	public ResponseEntity<DataTransfer> getOrderDetailByMinAmount() {
		OrderProd orders = orderService.getOrderDetailByMinAmount();
		return ResponseEntity.ok().body(new DataTransfer(orders.getOrderId(), orders.getCustId().getCustName(),
				orders.getProdId().getProdName(), orders.getQty(), orders.getProdId().getPrice(),
				orders.getTotal()));
	}
}
