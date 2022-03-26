package com.medicare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicare.Entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query(value = "select u from Customer u where u.username=?1 and u.password=?2")
	Optional<Customer> findByUsernameAndPassword(String username, String password);
	
	Customer getById(long id);

}
