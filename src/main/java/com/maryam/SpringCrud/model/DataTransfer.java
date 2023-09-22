package com.maryam.SpringCrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DataTransfer")
public class DataTransfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private int orderId;

	@Column(name = "custName")
	private String custName;
	
	@Column(name = "prodName")
	private String prodName;

	@Column(name = "qty")
	private int qty;

	@Column(name = "price")
	private int price;

	@Column(name = "total")
	private int total;
	
	
	public DataTransfer(int orderId, String custName, String prodName, int qty, int price,int total) {
		this.orderId = orderId;
		this.custName = custName;
		this.prodName = prodName;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}
	
	public DataTransfer() {
		// TODO Auto-generated constructor stub
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
