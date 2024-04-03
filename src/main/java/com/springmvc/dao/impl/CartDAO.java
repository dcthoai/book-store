package com.springmvc.dao.impl;

import java.util.List;

import com.springmvc.dao.ICartDAO;
import com.springmvc.mapper.MapperCart;
import com.springmvc.model.Cart;
import com.springmvc.model.CartProduct;

public class CartDAO extends AbstractDAO<Cart> implements ICartDAO{

	@Override
	public int insert(Cart cart) {
		String sql = "INSERT INTO `bookstore`.`cart` (`customerID`, `totalPayment`, `quantity`, `createdBy`) VALUES (?, ?, ?, ?)";
		
        int cartId = executeInsert(sql, cart.getCustomerId(), cart.getTotalPayment(), cart.getQuantity(), cart.getCreatedBy());
        
        return cartId;
	}

	@Override
	public int update(Cart cart) {
		String sql = "INSERT INTO `bookstore`.`cart` (`customerID`, `totalPayment`, `quantity`, `modifiedBy`) VALUES (?, ?, ?, ?)";
		
		int affectedRows = executeUpdate(sql, cart.getCustomerId(), cart.getTotalPayment(), cart.getQuantity(), cart.getModifiedBy());
        
        return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`cart` WHERE (`cartID` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		
		return affectedRows;
	}

	@Override
	public Cart getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`cart` WHERE (`cartID` = ?)";
		
		List<Cart> listCarts = executeQuery(sql, new MapperCart(), id);
		
		return listCarts.isEmpty() ? null : listCarts.get(0);
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
