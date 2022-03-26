package com.medicare.service;

import java.util.List;

import com.medicare.Entity.ProductCategory;

public interface ProductCategoryService {
	
	public String addCategory(ProductCategory category);
	public String removeCategory(long id);
	public List<ProductCategory> getAllCategory();

}
