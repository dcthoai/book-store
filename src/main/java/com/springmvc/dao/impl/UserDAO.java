package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IUserDAO;
import com.springmvc.mapper.MapperUserCustom;
import com.springmvc.model.UserCustom;

@Repository
public class UserDAO extends AbstractDAO<UserCustom> implements IUserDAO{

	@Override
	public int insert(UserCustom user) {
		String sql = "INSERT INTO `bookstore`.`user` (`username`, `password`, `email`, `role`, `createdBy`) VALUES (?, ?, ?, ?, ?)";
		
		int userId = executeInsert(sql, user.getUsername(),
										user.getPassword(),
										user.getEmail(),
										user.getRole(),
										user.getCreatedBy());
		
		return userId;
	}

	@Override
	public int update(UserCustom user) {
		String sql = "UPDATE `bookstore`.`user` SET `email` = ?, "
												+ "`password` = ?, "
												+ "`phone` = ?, "
												+ "`address` = ?, "
												+ "`token` = ?, "
												+ "`fullname` = ?, "
												+ "`modifiedBy` = ? WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, user.getEmail(), 
											  user.getPassword(),
											  user.getPhone(),
											  user.getAddress(),
											  user.getToken(),
											  user.getFullname(),
											  user.getModifiedBy(),
											  user.getId());
		
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`user` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		
		return affectedRows;
	}

	@Override
	public UserCustom getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE (`id` = ?)";
		
		List<UserCustom> listUsers = executeQuery(sql, new MapperUserCustom(), id);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}

	@Override
	public UserCustom getUserByUsername(String username) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE (`username` = ?)";
		
		List<UserCustom> listUsers = executeQuery(sql, new MapperUserCustom(), username);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}

	@Override
	public List<UserCustom> getAllUsers() {
		String sql = "SELECT * FROM `bookstore`.`user`";
		
		List<UserCustom> listUsers = executeQuery(sql, new MapperUserCustom());
		
		return listUsers;
	}

	@Override
	public UserCustom getUserByEmail(String email) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE (`email` = ?)";
		
		List<UserCustom> listUsers = executeQuery(sql, new MapperUserCustom(), email);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}
}
