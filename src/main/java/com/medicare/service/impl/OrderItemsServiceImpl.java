package com.medicare.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.Entity.Customer;
import com.medicare.Entity.Order;
import com.medicare.Entity.OrderItems;
import com.medicare.Entity.Product;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.repository.OrderItemsRepository;
import com.medicare.repository.OrderRepository;
import com.medicare.service.OrderItemsService;

@Service
public class OrderItemsServiceImpl implements OrderItemsService{
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	

	@Override
	public String addItem(long quantity, Order order, Product product) {
    //OrderItems orderItems = new OrderItems();
    System.out.println(product.toString());
    
   
		
		//orderItems.setQuantity(quantity);		
		//orderItems.setOrders(order);
		//orderItems.setProduct(product);
		BigDecimal total = new BigDecimal(BigInteger.ZERO,2);
		total = (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
		
		//orderItems.setTotal_item_cost(total);
		//orderItemsRepository.save(orderItems);
		OrderItems orderItems = new OrderItems(quantity,total,order,product);
		orderItemsRepository.save(orderItems);
		return "Items Saved";
	}

	@Override
	public String deleteItem(long id) {
		orderItemsRepository.deleteById(id);
		return "Line Item Removed";
	}

	@Override
	public List<OrderItems> OrderItemsById(long orderId) {
		
			Optional<Order> ord = orderRepository.findById(orderId);
			if(ord.isPresent()) {
				Order ordObj = ord.get();
				return ordObj.getItems();
			}
			else {
				throw new ResourceNotFoundException("Order","orderId","Not valid");
			}
		}

	@Override
	public String updateQuantity(long quantity, long id) {
		orderItemsRepository.changeQuantity(quantity, id);
		return "Changed Quantity";
	}

	

		

}
