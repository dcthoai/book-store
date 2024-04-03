package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Order;

public class MapperOrder implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		
		order.setId(rs.getInt("orderID"));
		order.setCustomerId(rs.getInt("customerID"));
		order.setOrderDate(rs.getDate("orderDate"));
		order.setOrderStatus(rs.getString("orderStatus"));
		order.setCreatedDate(rs.getTimestamp("createdDate"));
		order.setModifiedDate(rs.getTimestamp("modifiedDate"));
		order.setCreatedBy(rs.getString("createdBy"));
		order.setModifiedBy(rs.getString("modifiedBy"));
		
		return order;
	}
}