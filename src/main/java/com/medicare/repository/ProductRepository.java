package com.medicare.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.medicare.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	
	@Modifying
	@Transactional
	@Query(value = "update Product u set u.active=:status where u.id=:id")
	void changeStatus( @Param(value = "status") boolean status,@Param(value = "id") Long id);
	
	
}
