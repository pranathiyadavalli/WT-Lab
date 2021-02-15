package com.dto;

public class Cart {
	protected int id;
	protected Book book;
	protected User user;
	protected int quantity;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int id, Book book, User user, int quantity) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
