package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.User;

public interface IUserDAO extends IGenericDAO<User>{
	public User getUserByUsername(String username);
	public User getUserByEmail(String Email);
	public User getUserByPhone(String phoneNumber);
	public List<User> getAllUsers();
}