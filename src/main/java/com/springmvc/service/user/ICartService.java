package com.springmvc.service.user;

import java.util.List;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.springmvc.model.Book;
import com.springmvc.model.Cart;
import com.springmvc.model.CartProduct;

public interface ICartService{
	public int insertCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(int cartId);
	public Cart getCartById(int cartId);
	public Cart getCartByUserId(int userId);
	public int addCartProduct(CartProduct cartProduct);
	public boolean updateCartProduct(CartProduct cartProduct);
	public boolean deleteCartProduct(int cartProductId);
	public List<Pair<Book, Integer>> getAllCartProducts(int cartId);
}