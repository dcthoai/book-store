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
		payment.setOrderId(rs.getInt("orderID"));
		payment.setCustomerId(rs.getInt("customerID"));
		payment.setPaymentMethod(rs.getString("paymentMethod"));
		payment.setTotal(rs.getLong("total"));
		
		return payment;
	}
}