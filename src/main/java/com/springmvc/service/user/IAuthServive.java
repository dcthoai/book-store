package com.springmvc.service.user;

import com.springmvc.model.User;

public interface IAuthServive {
	public boolean isExistUser(String username, String email);
	public int register(User user);
	public boolean login(User user);
}