package com.medicare.Entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.medicare.Entity.Product;

import lombok.Data;


@Data
@Entity
@Table(name = "order_items")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;

	private long quantity;
	private BigDecimal total_item_cost;
	
	@ManyToOne//(fetch = FetchType.LAZY,cascade = CascadeType.ALL ,optional = false)
	@JoinColumn(name = "orderId")
	private Order orders;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "prodId")
	private Product product;

	public OrderItems() {
		super();
	}

	public OrderItems(long quantity, BigDecimal total_item_cost, Order orders, Product product) {
		super();
		this.quantity = quantity;
		this.total_item_cost = total_item_cost;
		this.orders = orders;
		this.product = product;
	}

	public long getItemId() {
		return itemId;
	}

	public long getQuantity() {
		return quantity;
	}

	public BigDecimal getTotal_item_cost() {
		return total_item_cost;
	}
	
	@JsonBackReference
	public Order getOrders() {
		return orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public void setTotal_item_cost(BigDecimal total_item_cost) {
		this.total_item_cost = total_item_cost;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	}
