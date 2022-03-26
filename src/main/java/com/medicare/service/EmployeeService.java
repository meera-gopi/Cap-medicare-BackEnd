package com.medicare.service;

import com.medicare.Entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
	public Employee authEmployee(String userName,String password);

}
