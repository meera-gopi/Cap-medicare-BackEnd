package com.medicare.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicare.Entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {

	@Modifying
	@Transactional
	@Query(value = "update OrderItems u set u.quantity=:quantity where u.id=:id")
	void changeQuantity( @Param(value = "quantity") long quantity,@Param(value = "id") Long id);
}
