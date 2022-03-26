package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.Entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
