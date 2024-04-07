package com.springmvc.dao;

import com.springmvc.model.UserCustom;

public interface IUserCustomDAO extends IGenericDAO<UserCustom>{
	public UserCustom getUserByUsername(String username);
}