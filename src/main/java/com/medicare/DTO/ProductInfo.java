package com.medicare.DTO;

import java.math.BigDecimal;

public class ProductInfo {
	
	private long id;
	private String productName;
	
	private BigDecimal price;
	
	private String sellerName;
	
	private String description;
	
	private long productCategoryId;
	
	private boolean active;
	
	

	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", productName=" + productName + ", price=" + price + ", sellerName="
				+ sellerName + ", description=" + description + ", productCategoryId=" + productCategoryId + ", active="
				+ active + "]";
	}

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfo(long id, String productName, BigDecimal price, String sellerName, String description,
			long productCategoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.sellerName = sellerName;
		this.description = description;
		this.productCategoryId = productCategoryId;
	}
	
	public ProductInfo( String productName, BigDecimal price, String sellerName, String description,
			long productCategoryId, boolean active) {
		super();
		
		this.productName = productName;
		this.price = price;
		this.sellerName = sellerName;
		this.description = description;
		this.productCategoryId = productCategoryId;
		this.active=active;
	}


	public long getId() {
		return id;
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

	public long getProductCategoryId() {
		return productCategoryId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	

}
