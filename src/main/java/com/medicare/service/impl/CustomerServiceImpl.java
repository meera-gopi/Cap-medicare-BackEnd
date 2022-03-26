package com.medicare.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicare.DTO.Users;
import com.medicare.Entity.Customer;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.repository.CustomerRepository;
import com.medicare.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	private Users logedInUser;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub	
		return customerRepository.save(customer);
	}


	@Override
	public Users authCustomer(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("Service Impl");
		Optional<Customer> cust = (Optional<Customer>) customerRepository.findByUsernameAndPassword(username, password);
		if(cust.isPresent()) {
			logedInUser=new Users(cust.get().getId(),cust.get().getFirstName(),cust.get().getLastName(),cust.get().getEmail(),cust.get().getPhone_Num(),
					cust.get().getUsername(),cust.get().getPassword(),cust.get().getAddress());
			System.out.println(logedInUser);
			return logedInUser;
		}
		else {
			throw new ResourceNotFoundException("Customer","UserName",username);
		}
		
		
	}


	@Override
	public Customer findCustomerById(long id) {
		
		return customerRepository.getById(id);
	}
	
	
	
	

}
