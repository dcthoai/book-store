package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Order;

public class MapperOrder implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		
		order.setId(rs.getInt("id"));
		
        order.setCustomerId(rs.getInt("customerId"));
        order.setAddress(rs.getString("address"));
        order.setOrderStatus(rs.getInt("orderStatus"));
        order.setPaymentStatus(rs.getInt("paymentStatus"));
        order.setShippingStatus(rs.getInt("shippingStatus"));
        
        order.setTotalPrice(rs.getLong("totalPrice"));
        order.setShippingCost(rs.getLong("shippingCost"));
        order.setDiscount(rs.getLong("discount"));
        order.setTotalPayment(rs.getLong("totalPayment"));
        order.setPaymentMethod(rs.getString("paymentMethod"));
        order.setShippingUnit(rs.getString("shippingUnit"));
        order.setShippingMethod(rs.getString("shippingMethod"));
        order.setShipperPhone(rs.getString("shipperPhone"));
        
        order.setOrderDate(rs.getTimestamp("orderDate"));
        order.setEstimatedArrival(rs.getTimestamp("estimatedArrival"));
        order.setDeliveredAt(rs.getTimestamp("deliveredAt"));
        
        order.setCreatedDate(rs.getTimestamp("createdDate"));
        order.setModifiedDate(rs.getTimestamp("modifiedDate"));
        order.setCreatedBy(rs.getString("createdBy"));
        order.setModifiedBy(rs.getString("modifiedBy"));
		
		return order;
	}
}