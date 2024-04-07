package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springmvc.model.Customer;

public class MapperCustomer implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        
        customer.setId(rs.getInt("id"));
        
        customer.setUserId(rs.getInt("userId"));
        customer.setAvatarId(rs.getInt("avatarId"));
        customer.setFullname(rs.getString("fullname"));
        customer.setPhone(rs.getString("phone"));
        customer.setEmail(rs.getString("email"));
        customer.setBirthday(rs.getDate("birthday"));
        
        customer.setCreatedDate(rs.getTimestamp("createdDate"));
        customer.setModifiedDate(rs.getTimestamp("modifiedDate"));
        customer.setCreatedBy(rs.getString("createdBy"));
        customer.setModifiedBy(rs.getString("modifiedBy"));
        
        return customer;
    }
}