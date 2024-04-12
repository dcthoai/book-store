package com.springmvc.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.CartDAO;
import com.springmvc.dao.impl.CartProductDAO;
import com.springmvc.model.Book;
import com.springmvc.model.Cart;
import com.springmvc.model.CartProduct;
import com.springmvc.model.Pair;
import com.springmvc.service.user.ICartService;

@Service
public class CartService implements ICartService {

	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private CartProductDAO cartProductDAO;
	@Autowired
	private BookService bookService;

	@Override
	public int insertCart(Cart cart) {
		int cartId = cartDAO.insert(cart);
		
		return cartId;
	}

	@Override
	public boolean updateCart(Cart cart) {
		int affectedRows = cartDAO.update(cart);
		
		return affectedRows > 0;
	}

	@Override
	public boolean deleteCart(int cartId) {
		int affectedRowes = cartDAO.delete(cartId);
		
		return affectedRowes > 0;
	}

	@Override
	public Cart getCartById(int cartId) {
		Cart cart = cartDAO.getById(cartId);
		
		return cart;
	}

	@Override
	public Cart getCartByUserId(int userId) {
		Cart cart = cartDAO.getCartByUserId(userId);
		
		return cart;
	}

	@Override
	public int addCartProduct(CartProduct cartProduct) {
		int cartProductId = cartProductDAO.insert(cartProduct);
		
		return cartProductId;
	}

	@Override
	public boolean updateCartProduct(CartProduct cartProduct) {
		int affectedRows = cartProductDAO.update(cartProduct);
		
		return affectedRows > 0;
	}

	@Override
	public boolean deleteCartProduct(int cartProductId) {
		int affectedRows = cartProductDAO.delete(cartProductId);
		
		return affectedRows > 0;
	}

	@Override
	public List<Pair<Book, CartProduct>> getAllCartProducts(int cartId) {
		List<Pair<Book, CartProduct>> cartProductPairs = new ArrayList<Pair<Book, CartProduct>>();
	    List<CartProduct> cartProducts = cartProductDAO.getAllCartProducts(cartId);

	    for (CartProduct cartProduct : cartProducts) {
	        Book book = bookService.getBookById(cartProduct.getBookId());
	        
	        cartProductPairs.add(new Pair<Book, CartProduct>(book, cartProduct));
	    }

	    return cartProductPairs;
	}
}