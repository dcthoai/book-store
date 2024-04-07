package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springmvc.model.Publisher;

public class MapperPublisher implements RowMapper<Publisher> {

    @Override
    public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        
        publisher.setId(rs.getInt("id"));
        
        publisher.setName(rs.getString("name"));
        publisher.setAddress(rs.getString("address"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));
        
        publisher.setCreatedDate(rs.getTimestamp("createdDate"));
        publisher.setModifiedDate(rs.getTimestamp("modifiedDate"));
        publisher.setCreatedBy(rs.getString("createdBy"));
        publisher.setModifiedBy(rs.getString("modifiedBy"));
        
        return publisher;
    }
}