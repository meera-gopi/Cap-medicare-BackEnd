package com.medicare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.DTO.OrderInfo;
import com.medicare.Entity.Customer;
import com.medicare.Entity.Order;
import com.medicare.Entity.OrderStatus;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.repository.CustomerRepository;
import com.medicare.repository.OrderRepository;
import com.medicare.repository.OrderStatusRepository;
import com.medicare.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderStatusRepository statusRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	private OrderInfo orders_to_sent;
	

	@Override
	public Order saveOrder(OrderInfo info) {
		OrderStatus status = statusRepository.findById(info.getStatusId()).get();
		Customer customer = customerRepository.getById(info.getCustomerId());
		Order ord= new Order(info.getOrderDate(),status,customer);
		orderRepository.save(ord);
		return ord;
	}

	@Override
	public String updateOrder(OrderInfo info) {
		OrderStatus status = statusRepository.findById(info.getStatusId()).get();
		
		
		Optional<Order> ord = orderRepository.findById(info.getOrderId());
		if(ord.isPresent()) {
			Order order = ord.get();
			order.setStatus(status);
			orderRepository.save(order);
			return "success";
		}
		
		else {
			throw new ResourceNotFoundException("Order","OrderId","Not valid");
		}
	}

	@Override
	public List<Order> listAllOrderForCustomer(long id) {
		Optional<Customer> cust = customerRepository.findById(id);
		if(cust.isPresent()) {
			//return orderRepository.sortByDate( );
			
			
		 Customer cust1=cust.get();
		 List<Order> l1=cust1.getOrders();
		 System.out.println(l1);
		//return  orderRepository.findAllActiveOrders(id);
			return l1;
		}
		else {
			throw new ResourceNotFoundException("Customer","CustomerId","Not valid");
		}
	}

	@Override
	public Order getOrder(long id) {
		// TODO Auto-generated method stub
		return orderRepository.getById(id);
	}

	@Override
	public String updateStatusToPaid(long id) {
		OrderStatus status = statusRepository.findById((long) 2).get();
		
		Optional<Order> ord = orderRepository.findById(id);
		if(ord.isPresent()) {
			Order order = ord.get();
			order.setStatus(status);
			orderRepository.save(order);
			return "success";
		}
		
		else {
			throw new ResourceNotFoundException("Order","OrderId","Not valid");
		}
	}

}
