package com.medicare.DataApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.medicare.repository.CustomerRepository;
import com.medicare.repository.EmployeeRepository;
import com.medicare.repository.OrderItemsRepository;
import com.medicare.repository.OrderRepository;
import com.medicare.repository.OrderStatusRepository;
import com.medicare.repository.ProductCategoryRepository;
import com.medicare.repository.ProductRepository;

@SpringBootApplication
@EntityScan("com.medicare.Entity")
@EnableJpaRepositories(basePackageClasses= {CustomerRepository.class,EmployeeRepository.class,OrderItemsRepository.class,OrderRepository.class,OrderStatusRepository.class,ProductCategoryRepository.class,ProductRepository.class})
@ComponentScan(basePackages= {"com.medicare.Entity","com.medicare.repository","com.medicare.service","com.medicare.service.impl","com.medicare.controller","com.medicare.DTO"})
public class DataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataApiApplication.class, args);
	}

}
