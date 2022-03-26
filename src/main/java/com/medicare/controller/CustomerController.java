package com.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.DTO.Users;
import com.medicare.Entity.Customer;
import com.medicare.service.CustomerService;

@RestController
@RequestMapping(value = "/customer", method = RequestMethod.GET)

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

//	public CustomerController(CustomerService customerService) {
//		super();
//		this.customerService = customerService;
//	}
	
	//Save Customer Info
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/saveInfo")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		System.out.println(customer.getUsername());
		return new ResponseEntity<Customer> (customerService.save(customer),HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<Users> authCustomer(@RequestBody Users cred){
		return new ResponseEntity<Users> (customerService.authCustomer(cred.getUsername(), cred.getPassword()),HttpStatus.OK);
		
	}

}
