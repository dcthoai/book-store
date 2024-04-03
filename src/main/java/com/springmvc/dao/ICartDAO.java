package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Cart;
import com.springmvc.model.CartProduct;

public interface ICartDAO extends IGenericDAO<Cart>{
	public Cart getCartByUserId(int userId);
	public int getQuantityCart(int userId);
	public long getTotalPayment(int userId);
	public List<CartProduct> getAllCartProducts(int userId);
	public boolean addCartProduct(int cartId, int bookId, int quantity);
	public boolean updateCartProduct(int cartId, int cartProductId, int quantity);
	public boolean deleteCartProduct(int cartId, int cartProductId);
}