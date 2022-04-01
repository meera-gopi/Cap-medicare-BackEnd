package com.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.Entity.OrderStatus;
import com.medicare.service.OrderStatusService;

@RestController
@RequestMapping(value="/orderStatus")
public class OrderStatusController {
	
	@Autowired
	private OrderStatusService orderStatusService;
	
	@CrossOrigin(origins="http://ec2-54-242-151-100.compute-1.amazonaws.com")
	@PostMapping("/addStatus")
	public String addStatus(@RequestBody OrderStatus status) {
		
		return orderStatusService.addStaus(status);
		
	}
	
	@CrossOrigin(origins="http://ec2-54-242-151-100.compute-1.amazonaws.com")
	@DeleteMapping("/removeStatus/{statusId}")
	public String removeStatus(@PathVariable("statusId") long id) {
		return orderStatusService.removeStaus(id);
	}

}
