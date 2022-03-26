package com.medicare.service;

import com.medicare.Entity.OrderStatus;

public interface OrderStatusService {
	
	public String addStaus(OrderStatus status);
	public String removeStaus(long id);

}
