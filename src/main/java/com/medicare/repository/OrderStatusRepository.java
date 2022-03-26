package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.Entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Long> {

}
