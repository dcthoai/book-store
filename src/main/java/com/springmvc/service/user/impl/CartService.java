package com.springmvc.service.user.impl;

import java.util.List;

import com.springmvc.model.Cart;
import com.springmvc.model.CartProduct;
import com.springmvc.service.user.ICartService;

public class CartService implements ICartService{

	@Override
	public int insertCart(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCartByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQuantityCart(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTotalPayment(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CartProduct> getAllCartProducts(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCartProduct(int cartId, int bookId, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCartProduct(int cartId, int cartProductId, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCartProduct(int cartId, int cartProductId) {
		// TODO Auto-generated method stub
		return false;
	}
}