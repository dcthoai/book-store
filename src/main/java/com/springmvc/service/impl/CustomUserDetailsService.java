package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.UserDAO;
import com.springmvc.model.UserCustom;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCustom user = userDAO.getUserByUsername(username);
		
		if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

		return user;
	}
	
	public UserCustom getUserByUsername(String username) {
		UserCustom user = userDAO.getUserByUsername(username);
		
		return user;
	}
	
	public UserCustom getUserByEmail(String email) {
		UserCustom user = userDAO.getUserByEmail(email);
		
		return user;
	}
	
	public boolean existUser(String username, String email) {
		if (getUserByUsername(username) != null)
			return true;
		if (getUserByEmail(email) != null)
			return true;
		return false;
	}
	
	public UserCustom getUserById(int id) {
		return userDAO.getById(id);
	}
	
	public int insert(UserCustom user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		
		return userDAO.insert(user);
	}
	
	public int update(UserCustom user) {
		return userDAO.update(user);
	}
	
	public List<UserCustom> getAllUsers(){
		return userDAO.getAllUsers();
	}
}