package com.springmvc.service.user;

import com.springmvc.model.User;

public interface IAuthServive {
	public String encryptPassword(String password);
	public int register(User user);
	public boolean isMatchesPassword(String password, String encryptedPassword);
	public boolean isExistUser(String username, String email);
	public boolean login(User user);
}