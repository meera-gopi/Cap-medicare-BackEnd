package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.DTO.OrderInfo;
import com.medicare.Entity.Order;
import com.medicare.Entity.OrderItems;
import com.medicare.Entity.Product;
import com.medicare.service.OrderItemsService;
import com.medicare.service.OrderService;
import com.medicare.service.ProductService;

@RestController
@RequestMapping(value="/orders",method=RequestMethod.GET)
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemsService orderItemsService;
	@Autowired
	private ProductService productService;
	//@Autowired
	//private CustomerService customerService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/saveOrder")
	public long saveOrder(@RequestBody OrderInfo info) {
	
//		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//		long st=3;
//		OrderInfo info=new OrderInfo(new Date(),st,id);
		Order order = orderService.saveOrder(info);
		long order_id = order.getOrderId();
		return order_id;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addItem")
	public String addItem(@RequestBody OrderInfo info) {
		
		System.out.println(info.toString());
//		long prod_id=info.getProductId();
//		long order_id=info.getOrderId();
//		long quantity = info.getQuantity();
//		System.out.println(prod_id);
//		System.out.println(order_id);
//		System.out.println(quantity);
//		Product product =productService.getProduct(prod_id);
//		Order order = orderService.getOrder(order_id);
		
		Product product = productService.getProduct(info.getProductId());
		Order order = orderService.getOrder(info.getOrderId());
		
		
		//return orderItemsService.addItem(quantity, order, product);
		
		return orderItemsService.addItem(info.getQuantity(), order, product);
		
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/removeItem/{itemId}")
	public String removeItem(@PathVariable("itemId") long id) {
		return orderItemsService.deleteItem(id);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/allOrders/{custId}")
	public List<Order> getOrderItems(@PathVariable("custId") long custId) {
		return orderService.listAllOrderForCustomer(custId);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/itemList/{orderId}")
	public List<OrderItems> getItemList(@PathVariable("orderId") long orderId){
		return orderItemsService.OrderItemsById(orderId);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/paid/{orderId}")
	public String updateStatusToPaid(@PathVariable("orderId") long orderId) {
		return orderService.updateStatusToPaid(orderId);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/updateQty/{quantity}/{id}")
	public String updateStatusToPaid(@PathVariable("quantity") long quantity,@PathVariable("id") long id) {
		return orderItemsService.updateQuantity(quantity, id);
	}


}
