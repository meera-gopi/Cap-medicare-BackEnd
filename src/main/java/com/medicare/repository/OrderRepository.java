package com.medicare.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicare.DTO.OrderInfo;
import com.medicare.Entity.Order;


public interface OrderRepository extends JpaRepository<Order,Long> {
	
	
	//Sorting
//	@Query(value="select new com.medicare.DTO.OrderInfo(o.orderId,o.orderDate,o.status,i.prodId,i.quantity,i.total_item_cost) from Orders o JOIN o.items i  order by o.orderDate desc")
   // public List<OrderInfo> sortByDate();
	
	
	//@Query(value="SELECT u.order_id,u.order_date FROM orders u WHERE u.id = :id",nativeQuery = true)
	//public List<Order> findAllActiveOrders( @Param(value = "id") long id);
	
	Order getByOrderId(long id);
	
	Order getById(long id);
	
	
	
	

}
