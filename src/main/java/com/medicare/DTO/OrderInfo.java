package com.medicare.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderInfo {

	private long orderId;
	@JsonFormat(pattern="dd-mm-YYYY")
	private Date orderDate;
	private long statusId;
	private long customerId;
	private long productId;
	private long quantity;
	private long totalItemCost;
	

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderDate=" + orderDate + ", statusId=" + statusId + ", customerId="
				+ customerId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public OrderInfo(Date orderDate, long statusId, long customerId) {
		super();
		this.orderDate = orderDate;
		this.statusId = statusId;
		this.customerId = customerId;
		
	}
	
	public OrderInfo(Date orderDate, long statusId) {
		super();
		this.orderDate = orderDate;
		this.statusId = statusId;
		
		
	}

	public OrderInfo(long quantity,long orderId, long productId) {
		super();
		this.quantity = quantity;
		this.orderId = orderId;
		this.productId = productId;
	}
	
	public OrderInfo(long orderId,Date orderDate, long statusId, long productId,long quantity,long totalItemCost) {
		super();
		this.orderId = orderId;
		this.orderDate=orderDate;
		this.statusId = statusId;
		this.productId=productId;
		this.quantity=quantity;
		this.totalItemCost=totalItemCost;
	
		
	}
	

	public long getOrderId() {
		return orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public long getStatusId() {
		return statusId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}



	public long getQuantity() {
		return quantity;
	}



	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
