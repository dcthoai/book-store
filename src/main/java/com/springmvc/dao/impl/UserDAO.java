package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IUserDAO;
import com.springmvc.mapper.MapperUser;
import com.springmvc.model.User;

@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO{

	@Override
	public int insert(User user) {
		String sql = "INSERT INTO `bookstore`.`user` (`username`, `email`, `pass`, `createdBy`) VALUES (?, ?, ?, ?)";

		int userId = executeInsert(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getCreatedBy());
		return userId;
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE `bookstore`.`user` SET"
					 + "`username` = ?"
					 + "`phoneNumber` = ?"
					 + "`fullname` = ?"
					 + "`email` = ?"
					 + "`pass` = ?"
					 + "`avatar` = ?"
					 + "`birthday` = ?"
					 + "`modifiedBy` = ? WHERE `userID` = ?";
		
		int affectedRows = executeUpdate(sql, user.getUsername(),
												user.getPhoneNumber(),
												user.getFullname(),
												user.getEmail(),
												user.getPassword(),
												user.getAvatar(),
												user.getBirthday(),
												user.getModifiedBy());
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`user` WHERE (`userID` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		
		return affectedRows;
	}

	@Override
	public User getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE `userID` = ?";
		List<User> listUsers = executeQuery(sql, new MapperUser(), id);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}
	
	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE `username` = ?";
		List<User> listUsers = executeQuery(sql, new MapperUser(), username);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}

	@Override
	public User getUserByEmail(String email) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE `email` = ?";
		List<User> listUsers = executeQuery(sql, new MapperUser(), email);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}

	@Override
	public User getUserByPhone(String phoneNumber) {
		String sql = "SELECT * FROM `bookstore`.`user` WHERE `phoneNumber` = ?";
		List<User> listUsers = executeQuery(sql, new MapperUser(), phoneNumber);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}
	
	@Override
	public List<User> getAllUsers(){
		String sql = "SELECT * FROM `bookstore`.`user`";
		List<User> listUsers = executeQuery(sql, new MapperUser());
		
		return listUsers;
	}
}