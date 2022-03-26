package com.medicare.DTO;

import javax.persistence.Column;

public class Users {
	
    private long id;	
	private String firstName;	
	private String lastName;	
	private String email;	
	private long phone_Num;
	private String username;	
	private String password;			
	private String Address;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Users(long id, String firstName, String lastName, String email, long phone_Num, String username,
			String password, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone_Num = phone_Num;
		this.username = username;
		this.password = password;
		Address = address;
	}



	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}
	
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getPhone_Num() {
		return phone_Num;
	}



	public void setPhone_Num(long phone_Num) {
		this.phone_Num = phone_Num;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	

}

