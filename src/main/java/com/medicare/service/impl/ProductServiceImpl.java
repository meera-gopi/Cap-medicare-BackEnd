package com.medicare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.DTO.ProductInfo;
import com.medicare.Entity.Product;
import com.medicare.Entity.ProductCategory;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.repository.ProductCategoryRepository;
import com.medicare.repository.ProductRepository;
import com.medicare.service.ProductService;

@Service

public class ProductServiceImpl implements ProductService {
	
	
	private ProductRepository productRepository;
	@Autowired
	private ProductCategoryRepository prodCategoryRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public String addProduct(ProductInfo info) {
		System.out.println(info.toString());
		
		Optional<ProductCategory> cat = prodCategoryRepository.findById(info.getProductCategoryId());
		
		Product prod1=new Product(info.getProductName(),info.getPrice(),info.getSellerName(),info.getDescription(),cat.get(),info.isActive());
		productRepository.save(prod1);
		return "Product Saved Successfully";
	}

	@Override
	public String removeProduct(long id) {
		productRepository.deleteById(id);
		return "Product Removed";
	}

	@Override
	public String changeProductStatus(boolean status,long id) {		
		productRepository.changeStatus(status,id);	
		
		return "Updated Product Status";
	}

	@Override
	public String updateProduct(ProductInfo info) {
		System.out.println("ENTERED");
		System.out.println(info.toString());
		
		Optional<ProductCategory> cat = prodCategoryRepository.findById(info.getProductCategoryId());
		
		
		Optional<Product> prod = productRepository.findById(info.getId());
		if (prod.isPresent()) {
			System.out.println("ENTERED-1");
			info.toString();
			Product prod1 = prod.get();
			prod1.setDescription(info.getDescription());
			prod1.setPrice(info.getPrice());
			prod1.setCategory(cat.get());
			prod1.setProductName(info.getProductName());
			prod1.setSellerName(info.getSellerName());
			productRepository.save(prod1);
			return "values updated";
		}
		
		else {
			throw new ResourceNotFoundException("Product","productName",info.getProductName());
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {
		System.out.println(id);
		Optional<Product> prd =productRepository.findById(id);
		if(prd.isPresent())
		{
			return prd.get();
		}
		
		else {
			
			throw new ResourceNotFoundException("Product","productId","incorrect value passed");
		}
		
		
	}

}
