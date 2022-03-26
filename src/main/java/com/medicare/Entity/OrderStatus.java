package com.medicare.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_status")
public class OrderStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderStatusId;
	
	private String description;
	public OrderStatus() {}

	public OrderStatus(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
