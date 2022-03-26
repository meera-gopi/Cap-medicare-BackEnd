package com.medicare.service;

import com.medicare.DTO.Users;
import com.medicare.Entity.Customer;

public interface CustomerService {

	public Customer save (Customer customer);
	
	public Users authCustomer(String userName,String password);
	
	public Customer findCustomerById(long id);
		
	
}
