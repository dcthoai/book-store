package com.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.UserDAO;
import com.springmvc.model.User;
import com.springmvc.service.user.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	public int insertUser(User user) {
		int userId = userDAO.insert(user);
		return userId;
	}

	@Override
	public boolean updateUser(User user) {
		boolean statusUpdate = userDAO.update(user);
		return statusUpdate;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean statusDelete = userDAO.delete(id);
		return statusDelete;
	}

	@Override
	public User findUserById(int id) {
		User user = userDAO.getById(id);
		return user;
	}

	@Override
	public User findUserByUsername(String username) {
		User user = userDAO.getUserByUsername(username);
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userDAO.getUserByEmail(email);
		return user;
	}

	@Override
	public User findUserByPhone(String phone) {
		User user = userDAO.getUserByPhone(phone);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> listUsers = userDAO.getAllUsers();
		return listUsers;
	}
}