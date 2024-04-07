package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Address;

public class MapperAddress implements RowMapper<Address>{

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Address address = new Address();

	    address.setId(rs.getInt("id"));
	    
	    address.setCustomerId(rs.getInt("customerId"));
	    address.setPhone(rs.getString("phone"));
	    address.setAddress(rs.getString("address"));
	    address.setStreet(rs.getString("street"));
	    address.setWard(rs.getString("ward"));
	    address.setDistrict(rs.getString("district"));
	    address.setCity(rs.getString("city"));
	    address.setCountry(rs.getString("country"));
	    
	    address.setCreatedDate(rs.getTimestamp("createdDate"));
	    address.setModifiedDate(rs.getTimestamp("modifiedDate"));
	    address.setCreatedBy(rs.getString("createdBy"));
	    address.setModifiedBy(rs.getString("modifiedBy"));

	    return address;
	}

}