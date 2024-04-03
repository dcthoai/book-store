package com.springmvc.service.user;

import java.util.List;

import com.springmvc.model.Cart;
import com.springmvc.model.CartProduct;

public interface ICartService{
	public int insertCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(int id);
	public Cart getCartById(int id);
	public Cart getCartByUserId(int userId);
	public int getQuantityCart(int userId);
	public long getTotalPayment(int userId);
	public List<CartProduct> getAllCartProducts(int userId);
	public boolean addCartProduct(int cartId, int bookId, int quantity);
	public boolean updateCartProduct(int cartId, int cartProductId, int quantity);
	public boolean deleteCartProduct(int cartId, int cartProductId);
}