package com.medicare.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.Entity.OrderStatus;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.repository.OrderStatusRepository;
import com.medicare.service.OrderStatusService;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;

	@Override
	public String addStaus(OrderStatus status) {
		//OrderStatus status = new OrderStatus(description);
		orderStatusRepository.save(status);
		
		return "Saved Order Status";
	}

	@Override
	public String removeStaus(long id) {
		Optional<OrderStatus> status = orderStatusRepository.findById(id);
		if(status.isPresent()) {
			orderStatusRepository.deleteById(id);
			return "Status Removed";
		}
		else {
			throw new ResourceNotFoundException("OrderStatus","Id","invalid");
		}
	
	}

}
