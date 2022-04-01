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
import com.medicare.Entity.Employee;
import com.medicare.service.EmployeeService;

@RestController
@RequestMapping(value = "medicare/employee", method = RequestMethod.GET)
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

//	public EmployeeController(EmployeeService employeeService) {
//		super();
//		this.employeeService = employeeService;
//	}
	
	
	//Save Customer Info
	@CrossOrigin(origins="http://ec2-35-172-119-30.compute-1.amazonaws.com")
	@PostMapping("/saveInfo")
	public ResponseEntity<Employee> saveCustomer(@RequestBody Employee employee) {
		return new ResponseEntity<Employee> (employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://ec2-35-172-119-30.compute-1.amazonaws.com")
	@PostMapping("/login")
	public ResponseEntity<Employee> authCustomer(@RequestBody Users cred){
		System.out.println(cred.toString());
		return new ResponseEntity<Employee> (employeeService.authEmployee(cred.getUsername(), cred.getPassword()),HttpStatus.OK);
		
	}

	

	
}
