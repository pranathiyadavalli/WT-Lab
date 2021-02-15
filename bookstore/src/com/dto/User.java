package com.dto;

public class User {
	private int id;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String fullName;
	 private String email;
	 private String userName;
	 private String password;
	 private String creditCard;
	 
	 public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getUserName() {
	 return userName;
	 }
	 public void setUserName(String userName) {
	 this.userName = userName;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
	 this.password = password;
	 }
	 public void setFullName(String fullName) {
	 this.fullName = fullName;
	 }
	 public String getFullName() {
	 return fullName;
	 }
	 public void setEmail(String email) {
	 this.email = email;
	 }
	 public String getEmail() {
	 return email;
	 }
}
