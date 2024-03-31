package com.springmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.User;

public class MapperUser implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("userID"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("pass"));
		user.setPhoneNumber(rs.getString("phoneNumber"));
		user.setFullname(rs.getString("fullname"));
		user.setAvatar(rs.getInt("avatar"));
		user.setBirthday(rs.getDate("birthday"));
		user.setCreatedDate(rs.getTimestamp("createdDate"));
		user.setCreatedBy(rs.getString("createdBy"));
		user.setModifiedDate(rs.getTimestamp("modifiedDate"));
		user.setModifiedBy(rs.getString("modifiedBy"));
		return user;
	}
}
