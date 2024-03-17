package com.springmvc.model;

public class CartProduct{
	private int cartId, bookId, quantity;
	
	public CartProduct() {
		super();
	}
	
	public CartProduct(int cartId, int bookId, int quantity) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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