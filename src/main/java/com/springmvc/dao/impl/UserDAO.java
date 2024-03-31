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
		String sql = "INSERT INTO bookstore.User (username, email, pass) VALUES (?, ?, ?)";

		int userId = excecuteInsert(sql, user.getUsername(), user.getEmail(), user.getPassword());
		return userId;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(int id) {
		String sql = "SELECT * FROM bookstore.User WHERE userID = ?";
		List<User> listUsers = excecuteQuery(sql, new MapperUser(), id);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}
	
	@Override
	public User getUserByUsername(String username) {
		String sql = "SELECT * FROM bookstore.User WHERE username = ?";
		List<User> listUsers = excecuteQuery(sql, new MapperUser(), username);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}

	@Override
	public User getUserByEmail(String email) {
		String sql = "SELECT * FROM bookstore.User WHERE email = ?";
		List<User> listUsers = excecuteQuery(sql, new MapperUser(), email);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}

	@Override
	public User getUserByPhone(String phoneNumber) {
		String sql = "SELECT * FROM bookstore.User WHERE phoneNumber = ?";
		List<User> listUsers = excecuteQuery(sql, new MapperUser(), phoneNumber);
		
		return listUsers.isEmpty() ? null : listUsers.get(0);
	}
	
	@Override
	public List<User> getAllUsers(){
		String sql = "SELECT * FROM bookstore.User";
		List<User> listUsers = excecuteQuery(sql, new MapperUser());
		
		return listUsers.isEmpty() ? null : listUsers;
	}
}