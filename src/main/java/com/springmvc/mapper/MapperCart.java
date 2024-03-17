package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Cart;

public class MapperCart implements RowMapper<Cart>{

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		
		cart.setId(rs.getInt("cartID"));
		cart.setCustomerId(rs.getInt("customerID"));
		cart.setQuantity(rs.getInt("quantity"));
		cart.setTotalPayment(rs.getLong("totalPayment"));
		
		return cart;
	}
}