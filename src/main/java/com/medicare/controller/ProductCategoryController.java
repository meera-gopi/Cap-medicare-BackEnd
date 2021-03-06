package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.Entity.ProductCategory;
import com.medicare.service.ProductCategoryService;

@RestController
@RequestMapping(value="/productCategory", method = RequestMethod.GET)
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@CrossOrigin(origins="http://ec2-54-242-151-100.compute-1.amazonaws.com")
	@GetMapping("/")
	public String getAllCategoryRedirect(){
		return "welcome";
	}
	
	@CrossOrigin(origins="http://ec2-54-242-151-100.compute-1.amazonaws.com")
	@GetMapping("/getCategory")
	public List<ProductCategory> getAllCategory(){
		return productCategoryService.getAllCategory();
	}
	
	@CrossOrigin(origins="http://ec2-54-242-151-100.compute-1.amazonaws.com")
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody ProductCategory category) {
		return  productCategoryService.addCategory(category);
		
	}
	
	@DeleteMapping("/removeCategory/{catId}")
	public String removeCategory(@PathVariable("catId") long id) {
		return productCategoryService.removeCategory(id);
	}

}
