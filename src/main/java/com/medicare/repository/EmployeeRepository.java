package com.medicare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.medicare.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@Query(value = "select u from Employee u where u.userName=?1 and u.password=?2")
	Optional<Employee> findByUserNameAndPassword(String userName, String password);

}
