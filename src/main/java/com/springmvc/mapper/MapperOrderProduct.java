package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.OrderProduct;

public class MapperOrderProduct implements RowMapper<OrderProduct>{

	@Override
	public OrderProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderProduct orderProduct = new OrderProduct();
		
		orderProduct.setId(rs.getInt("orderProductId"));
		orderProduct.setOrderId(rs.getInt("orderID"));
		orderProduct.setBookId(rs.getInt("bookID"));
		orderProduct.setQuantity(rs.getInt("quantity"));
		orderProduct.setCreatedDate(rs.getTimestamp("createdDate"));
		orderProduct.setModifiedDate(rs.getTimestamp("modifiedDate"));
		orderProduct.setCreatedBy(rs.getString("createdBy"));
		orderProduct.setModifiedBy(rs.getString("modifiedBy"));
		
		return orderProduct;
	}
}