package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.UserCustom;

public interface IUserDAO extends IGenericDAO<UserCustom>{
	public UserCustom getUserByUsername(String username);
	public UserCustom getUserByEmail(String email);
	public List<UserCustom> getAllUsers();
}