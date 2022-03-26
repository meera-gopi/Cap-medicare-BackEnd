package com.medicare.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_category")
public class ProductCategory {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long prodCategoryId;
	
	private String description;
	

	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(String description) {
		super();
		this.description = description;
	}

	public long getProdCategoryId() {
		return prodCategoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setProdCategoryId(long prodCategoryId) {
		this.prodCategoryId = prodCategoryId;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
