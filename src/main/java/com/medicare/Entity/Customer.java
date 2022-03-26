package com.medicare.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private long phone_Num;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	private String password;
	
	private String Address;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Order> orders;//=new ArrayList<>();
	
	public Customer() {}

	public Customer(String firstName, String lastName, String email, long phone_Num, String username,
			String password, String Address) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone_Num = phone_Num;
		this.username = username;
		this.password = password;
		this.Address = Address;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getPhone_Num() {
		return phone_Num;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return Address;
	}
	
	@JsonManagedReference
	public List<Order> getOrders() {
		return orders;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone_Num(long phone_Num) {
		this.phone_Num = phone_Num;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
	

}
