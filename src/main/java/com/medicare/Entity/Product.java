package com.medicare.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long prodId;
	
	private String productName;
	
	private BigDecimal price;
	
	private String sellerName;
	
	@Column(length=2000)
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="prodCategoryId")
	@JsonIgnoreProperties(value = {"product", "hibernateLazyInitializer"})
	private ProductCategory category;
	
	private boolean active;
	
	public Product(){}
	public Product(String productName, BigDecimal price, String sellerName, String description,
			ProductCategory category, boolean active) {
		super();
		this.productName = productName;
		this.price = price;
		this.sellerName = sellerName;
		this.description = description;
		this.category = category;
		this.active = active;
	}
	
	

	public Product(long prodId, String productName, BigDecimal price, String sellerName, String description,
			ProductCategory category, boolean active) {
		super();
		this.prodId = prodId;
		this.productName = productName;
		this.price = price;
		this.sellerName = sellerName;
		this.description = description;
		this.category = category;
		this.active = active;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", productName=" + productName + ", price=" + price + ", sellerName="
				+ sellerName + ", description=" + description + ", category=" + category + ", active=" + active + "]";
	}
	
	
	
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getSellerName() {
		return sellerName;
	}
   
	public String getDescription() {
		return description;
	}

	

	public boolean isActive() {
		return active;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public void setActive(boolean active) {
		this.active = active;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	
	
	
	

}
