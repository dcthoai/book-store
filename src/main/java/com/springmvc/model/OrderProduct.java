package com.springmvc.model;

public class OrderProduct {
	private int orderId, bookId, quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(int orderId, int bookId, int quantity) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}