package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.CartProduct;

public interface ICartProductDAO extends IGenericDAO<CartProduct>{
	public List<CartProduct> getAllCartProducts(int cartId);
}