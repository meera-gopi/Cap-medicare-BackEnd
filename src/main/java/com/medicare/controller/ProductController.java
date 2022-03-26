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

import com.medicare.DTO.ProductInfo;
import com.medicare.Entity.Product;
import com.medicare.service.ProductService;

@RestController
@RequestMapping(value = "/product", method = RequestMethod.GET)

public class ProductController {

	@Autowired
	private ProductService productService;	
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/prouctList")	
	private List<Product> getAllgetAllProducts(){
		return productService.getAllProducts();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addProduct")
	private String addProduct(@RequestBody ProductInfo info) {
		
		return productService.addProduct(info);
		
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/removeProduct/{productId}")
		private String removeProduct(@PathVariable("productId") long id) {
			return productService.removeProduct(id);
		}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/updateProductStatus/{productId}/{status}")
	private String changeProductStatus (@PathVariable("productId") long id,@PathVariable("status") boolean status) {
		return productService.changeProductStatus(status,id);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/updateProductInfo")
	private String updateProduct(@RequestBody ProductInfo info) {
		return productService.updateProduct(info);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/getProduct/{productId}")
	private Product getProduct(@PathVariable("productId") long id) {
		return productService.getProduct(id);
	}
	
}
