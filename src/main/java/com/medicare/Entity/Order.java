package com.medicare.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	
	
	@OneToMany(mappedBy = "orders",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true--=new ArrayList<>()
	private List<OrderItems> items;//=new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="orderStatusId")
	private OrderStatus status;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id")
	private Customer customer;
	
	public Order() {
		
	}

	public Order(Date orderDate,  OrderStatus status, Customer customer) {
		super();
		this.orderDate = orderDate;
		
		this.status = status;
		this.customer = customer;
	}
	
	

	public long getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	
	@JsonManagedReference
	public List<OrderItems> getItems() {
		return items;
	}

	public OrderStatus getStatus() {
		return status;
	}
	
	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	

	public void setItems(List<OrderItems> items) {
		this.items = items;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
