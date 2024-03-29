package com.springmvc.service.user;

import java.util.List;

import com.springmvc.model.User;

public interface IUserService {
	public int insertUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	public User findUserById(int id);
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public User findUserByPhone(String phone);
	public List<User> getAllUsers();
}