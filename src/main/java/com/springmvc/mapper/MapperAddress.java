package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Address;

public class MapperAddress implements RowMapper<Address>{

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address = new Address();
		
		address.setId(rs.getInt("addressID"));
		address.setCustomerId(rs.getInt("customerID"));
		address.setPhoneNumber(rs.getString("phoneNumber"));
		address.setAddress(rs.getString("address"));
		address.setStreet(rs.getString("street"));
		address.setWard(rs.getString("ward"));
		address.setDistrict(rs.getString("district"));
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		
		return address;
	}
}