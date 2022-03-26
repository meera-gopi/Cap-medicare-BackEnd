package com.medicare.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicare.Entity.Employee;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.repository.EmployeeRepository;
import com.medicare.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee authEmployee(String userName, String password) {
		Optional<Employee> employee =(Optional<Employee>) employeeRepository.findByUserNameAndPassword(userName, password);
		if(employee.isPresent()) {
			System.out.println(employee.get().toString());
			return employee.get();
		}
		
		else {
			throw new ResourceNotFoundException("Employee","UserName",userName);
		}
		
		
		
	}

}
