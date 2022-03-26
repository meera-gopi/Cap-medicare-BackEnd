package com.medicare.service;

import java.util.List;

import com.medicare.DTO.OrderInfo;
import com.medicare.Entity.Order;

public interface OrderService {
	
	public Order saveOrder(OrderInfo info);
	public String updateOrder(OrderInfo info);
	public List<Order> listAllOrderForCustomer(long custId);
	public Order getOrder(long id);
	public String updateStatusToPaid(long id);
	

}
