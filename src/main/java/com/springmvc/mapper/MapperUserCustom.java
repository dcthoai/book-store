package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.springmvc.model.UserCustom;

public class MapperUserCustom implements RowMapper<UserCustom> {
	
	public Collection<GrantedAuthority> mapAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		return authorities;
	}

    @Override
    public UserCustom mapRow(ResultSet rs, int rowNum) throws SQLException {
    	UserCustom user = new UserCustom(rs.getString("username"),
    									 rs.getString("password"),
    									 mapAuthorities(rs.getString("role")),
    									 true, true, true, true);
    	user.setId(rs.getInt("id"));
    	
    	user.setEmail(rs.getString("email"));
    	user.setAddress(rs.getString("address"));
    	user.setFullname(rs.getString("fullname"));
    	user.setRole(rs.getString("role"));
    	user.setToken(rs.getString("token"));
    	user.setPhone(rs.getString("phone"));
    	
    	user.setCreatedDate(rs.getTimestamp("createdDate"));
    	user.setCreatedBy(rs.getString("createdBy"));
    	user.setModifiedDate(rs.getTimestamp("modifiedDate"));
    	user.setModifiedBy(rs.getString("modifiedBy"));
        
        return user;
    }
}