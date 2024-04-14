package com.springmvc.dao;

import com.springmvc.model.Cart;

public interface ICartDAO extends IGenericDAO<Cart>{
	public Cart getCartByCustomerId(int customerId);
}