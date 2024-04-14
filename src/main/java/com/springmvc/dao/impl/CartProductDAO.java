package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.ICartProductDAO;
import com.springmvc.mapper.MapperCartProduct;
import com.springmvc.model.CartProduct;

@Repository
public class CartProductDAO extends AbstractDAO<CartProduct> implements ICartProductDAO{

	@Override
	public int insert(CartProduct cartProduct) {
		String sql = "INSERT INTO `bookstore`.`cartProduct` "
						+ "(`cartId`, `bookId`, `quantity`, `createdBy`) VALUES (?, ?, ?, ?)";

		int cartProductId = executeInsert(sql, cartProduct.getCartId(), 
											   cartProduct.getBookId(), 
											   cartProduct.getQuantity(), 
											   cartProduct.getCreatedBy());
		return cartProductId;
	}

	@Override
	public int update(CartProduct cartProduct) {
		String sql = "UPDATE `bookstore`.`cartProduct` SET `quantity` = ?, `modifiedBy` = ? WHERE `id` = ?";
		
		int affectedRows = executeUpdate(sql, cartProduct.getQuantity(), 
											  cartProduct.getModifiedBy(), 
											  cartProduct.getId());
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`cartProduct` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		
		return affectedRows;
	}

	@Override
	public CartProduct getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`cartProduct` WHERE (`id` = ?)";
		
		List<CartProduct> listCartProducts = executeQuery(sql, new MapperCartProduct(), id);
		
		return listCartProducts.isEmpty() ? null : listCartProducts.get(0);
	}

	@Override
	public List<CartProduct> getAllCartProducts(int cartId) {
		String sql = "SELECT * FROM `bookstore`.`cartProduct` WHERE (`cartId` = ?)";
		
		List<CartProduct> listCartProducts = executeQuery(sql, new MapperCartProduct(), cartId);
		
		return listCartProducts;
	}
	
	@Override
	public CartProduct isExist(CartProduct cartProduct) {
		String sql = "SELECT * FROM `bookstore`.`cartProduct` WHERE (`cartId` = ? AND `bookId` = ?)";
		
		List<CartProduct> listCartProducts = executeQuery(sql, new MapperCartProduct(), 
																cartProduct.getCartId(), 
																cartProduct.getBookId());
		
		return listCartProducts.isEmpty() ? null : listCartProducts.get(0);
	}
	
	@Override
	public int countTotalCartQuantity(int cartId) {
		String sql = "SELECT SUM(quantity) FROM `bookstore`.`cartProduct` WHERE (`cartId` = ?)";
		
		Integer totalQuantity = _jdbcTemplate.queryForObject(sql, Integer.class, cartId);
        return totalQuantity != null ? totalQuantity : 0;
	}
}