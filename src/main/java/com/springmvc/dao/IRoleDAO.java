package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Role;
import com.springmvc.model.UserCustom;

public interface IRoleDAO extends IGenericDAO<Role>{
	public int insertAllUserRoles(UserCustom user);
	public int deleteAllUserRoles(int userId);
	public List<Role> getAllUserRoles(int userId);
}