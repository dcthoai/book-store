package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Payment;

public class MapperPayment implements RowMapper<Payment>{

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Payment payment = new Payment();
		
		payment.setId(rs.getInt("paymentID"));
		payment.setCustomerID(rs.getInt("customerID"));
		payment.setOrderID(rs.getInt("orderID"));
		payment.setPaymentMethod(rs.getString("paymentMethod"));
		payment.setTotal(rs.getLong("total"));
		
		payment.setCreatedDate(rs.getTimestamp("createdDate"));
		payment.setModifiedDate(rs.getTimestamp("modifiedDate"));
		payment.setCreatedBy(rs.getString("createdBy"));
		payment.setModifiedBy(rs.getString("modifiedBy"));
		
		return payment;
	}
}