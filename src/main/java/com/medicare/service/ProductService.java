package com.medicare.service;

import java.util.List;

import com.medicare.DTO.ProductInfo;
import com.medicare.Entity.Product;

public interface ProductService {
	
	String addProduct(ProductInfo info);
	
	String removeProduct(long id);
	
	String changeProductStatus(boolean status,long id);
	
	String updateProduct(ProductInfo info);
	
	List<Product> getAllProducts();
	
	Product getProduct(long id);

}
