package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.CartProduct;

public class MapperCartProduct implements RowMapper<CartProduct>{

	@Override
	public CartProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartProduct cartProduct = new CartProduct();
		
		cartProduct.setCartId(rs.getInt("cartID"));
		cartProduct.setBookId(rs.getInt("bookID"));
		cartProduct.setQuantity(rs.getInt("quantity"));
		
		return cartProduct;
	}
}