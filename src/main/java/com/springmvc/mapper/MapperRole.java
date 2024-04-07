package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springmvc.model.Role;

public class MapperRole implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        
        role.setId(rs.getInt("id"));
        
        role.setUserId(rs.getInt("userId"));
        role.setIsEnabled(rs.getInt("isEnabled"));
        role.setAuthority(rs.getString("authority"));
        
        role.setCreatedDate(rs.getTimestamp("createdDate"));
        role.setModifiedDate(rs.getTimestamp("modifiedDate"));
        role.setCreatedBy(rs.getString("createdBy"));
        role.setModifiedBy(rs.getString("modifiedBy"));
        
        return role;
    }
}