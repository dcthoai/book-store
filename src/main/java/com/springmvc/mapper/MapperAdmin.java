package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Admin;

public class MapperAdmin implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();

        admin.setId(rs.getInt("id"));
        
        admin.setUserId(rs.getInt("userId"));
        admin.setFullname(rs.getString("fullname"));
        admin.setPhone(rs.getString("phone"));
        admin.setEmail(rs.getString("email"));
        
        admin.setCreatedDate(rs.getTimestamp("createdDate"));
        admin.setModifiedDate(rs.getTimestamp("modifiedDate"));
        admin.setCreatedBy(rs.getString("createdBy"));
        admin.setModifiedBy(rs.getString("modifiedBy"));

        return admin;
    }
}