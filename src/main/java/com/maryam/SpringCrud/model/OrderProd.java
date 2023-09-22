package com.maryam.SpringCrud.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "OrderProd")
public class OrderProd implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;
	
    @Column(name = "qty")
    private int qty;
    
    
    @Column(name = "total")
    private int total;
    
    @JoinColumn(name = "custId", referencedColumnName = "custId")
    @ManyToOne(optional = false)
    private Customer custId;
    
    @JoinColumn(name = "prodId", referencedColumnName = "prodId")
    @ManyToOne(optional = false)
    private Product prodId;

    public OrderProd() {
    }

    public OrderProd(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderProd(Integer orderId, int qty, int total) {
        this.orderId = orderId;
        this.qty = qty;
        this.total = total;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    public Product getProdId() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }


    @Override
    public String toString() {
        return "entity.Orderprod[ orderId=" + orderId + " ]";
    }

}
