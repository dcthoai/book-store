package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Shipping;

public class MapperShipping implements RowMapper<Shipping>{

	@Override
	public Shipping mapRow(ResultSet rs, int rowNum) throws SQLException {
		Shipping shipping = new Shipping();
		
		shipping.setId(rs.getInt("shippingID"));
		shipping.setOrderId(rs.getInt("orderID"));
		shipping.setCustomerId(rs.getInt("customerID"));
		
		shipping.setShipperPhone(rs.getString("shipperPhone"));
		shipping.setShippingUnit(rs.getString("shippingUnit"));
		shipping.setShippingMethod(rs.getString("shippingMethod"));
		shipping.setShippingStatus(rs.getString("shippingStatus"));
		shipping.setShippingAddress(rs.getString("shippingAddress"));
		
		shipping.setShippingCost(rs.getLong("shippingCost"));
		shipping.setEstimatedArival(rs.getDate("estimatedArival"));
		shipping.setCreatedDate(rs.getTimestamp("createdDate"));
		shipping.setModifiedDate(rs.getTimestamp("modifiedDate"));
		shipping.setCreatedBy(rs.getString("createdBy"));
		shipping.setModifiedBy(rs.getString("modifiedBy"));
		
		return shipping;
	}
}