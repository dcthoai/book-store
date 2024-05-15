package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Customer;
import com.springmvc.model.UserCustom;

public interface IUserCustomDAO extends IGenericDAO<UserCustom>{
	public UserCustom getUserByUsername(String username);
	public List<UserCustom> getAllUsers();
}