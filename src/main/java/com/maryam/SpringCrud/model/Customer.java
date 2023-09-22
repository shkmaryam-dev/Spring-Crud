package com.maryam.SpringCrud.model;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Customer")
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custId")
	private int custId;
	
	@Column(name = "custName")
	private String custName;
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(
			mappedBy = "custId",
			cascade = CascadeType.ALL,
			orphanRemoval = true		
	)
	private Collection<OrderProd> orderprodCollection;
	
	public Customer() {
		
	}
		
	public Customer(int custId) {
		this.custId = custId;
	}
	
	public Customer(int custId, String custName, String address) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.address = address;
	}
	
	public int getCustId() {
		return custId;
	}
	
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + "]";
	}

}
