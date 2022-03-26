package com.medicare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.Entity.ProductCategory;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.repository.ProductCategoryRepository;
import com.medicare.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public String addCategory(ProductCategory category) {
		
		productCategoryRepository.save(category);
		return "successfully Saved";
	}

	@Override
	public String removeCategory(long id) {
		Optional<ProductCategory> category = productCategoryRepository.findById(id);
		
		if(category.isPresent()) {
			productCategoryRepository.deleteById(id);
			return "removed category";
		}
		else {
			throw new ResourceNotFoundException("ProductCategory","Id","invalid");
		}
	}

	@Override
	public List<ProductCategory> getAllCategory() {

		return productCategoryRepository.findAll();
	}

}
