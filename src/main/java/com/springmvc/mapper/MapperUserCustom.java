package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.springmvc.dao.impl.RoleDAO;
import com.springmvc.model.Role;
import com.springmvc.model.UserCustom;

public class MapperUserCustom implements RowMapper<UserCustom> {
	private final RoleDAO roleDAO;

    public MapperUserCustom(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public UserCustom mapRow(ResultSet rs, int rowNum) throws SQLException {
    	int userId = rs.getInt("id");
    	
    	List<Role> listUserRoles = roleDAO.getAllUserRoles(userId);
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	
    	for (Role role : listUserRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
        
        boolean enabled = (rs.getInt("enabled") == 1);
        boolean accountNonExpired = (rs.getInt("accountNonExpired") == 1);
        boolean credentialsNonExpired = (rs.getInt("credentialsNonExpired") == 1);
        boolean accountNonLocked = (rs.getInt("accountNonLocked") == 1);
        
        UserCustom user = new UserCustom(rs.getString("username"), 
        								 rs.getString("password"), 
        								 authorities, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked);
        
        user.setUserId(userId);
        
        return user;
    }
}