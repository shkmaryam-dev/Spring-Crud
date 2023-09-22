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
@Table(name = "Product")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodId")
	private Integer prodId;

	@Column(name = "prodName")
	private String prodName;

	@Column(name = "price")
	private int price;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId", orphanRemoval = true)
	private Collection<OrderProd> orderprodCollection;

	public Product() {
	}

	public Product(Integer prodId) {
		this.prodId = prodId;
	}

	public Product(Integer prodId, String prodName, int price) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "entity.Product[ prodId=" + prodId + " ]";
	}

}
