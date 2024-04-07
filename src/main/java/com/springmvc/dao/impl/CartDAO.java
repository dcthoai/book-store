package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ICartDAO;
import com.springmvc.mapper.MapperCart;
import com.springmvc.model.Cart;

@Repository
public class CartDAO extends AbstractDAO<Cart> implements ICartDAO{

	@Override
	public int insert(Cart cart) {
		
        return 0;
	}

	@Override
	public int update(Cart cart) {
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`cart` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		
		return affectedRows;
	}

	@Override
	public Cart getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`cart` WHERE (`id` = ?)";
		
		List<Cart> listCarts = executeQuery(sql, new MapperCart(), id);
		
		return listCarts.isEmpty() ? null : listCarts.get(0);
	}

	@Override
	public Cart getCartByUserId(int customerId) {
		String sql = "SELECT * FROM `bookstore`.`cart` WHERE (`customerId` = ?)";
		
		List<Cart> listCarts = executeQuery(sql, new MapperCart(), customerId);
		
		return listCarts.isEmpty() ? null : listCarts.get(0);
	}
}
