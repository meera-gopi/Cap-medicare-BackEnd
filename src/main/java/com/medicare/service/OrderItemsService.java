package com.medicare.service;

import java.util.List;

import com.medicare.Entity.Order;
import com.medicare.Entity.OrderItems;
import com.medicare.Entity.Product;

public interface OrderItemsService {

	public String addItem(long quantity, Order order,Product product);
	public String deleteItem(long id);
	//Order
		public List<OrderItems> OrderItemsById(long orderId);
	public String updateQuantity(long quantity,long id);
}
