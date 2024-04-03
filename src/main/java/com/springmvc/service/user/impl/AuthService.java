package com.springmvc.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springmvc.model.User;
import com.springmvc.service.user.IAuthServive;

@Service
public class AuthService implements IAuthServive{
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean isExistUser(String username, String email) {
		if (email == null && username == null)
			return false;
		
		if (email != null && email.equals("") == false) {
			if (userService.findUserByEmail(email) != null) {
				return true;
			}
		}

		if (username != null && username.equals("") == false) {
			if (userService.findUserByUsername(username) != null)
				return true;
	    }
	    
	    return false;
	}
	
	@Override
	public String encryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder.encode(password);
	}
	
	@Override
	public boolean isMatchesPassword(String password, String encryptedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder.matches(password, encryptedPassword);
	}
	
	@Override
	public int register(User user) {
		String password = user.getPassword();
			
		// Encrypt password before save
		String encryptedPassword = encryptPassword(password);
		user.setPassword(encryptedPassword);
			
		int userId = userService.insertUser(user);
			
		return userId; // Return userId when register success
	}

	@Override
	public boolean login(User user) {
		try {
			String email = user.getEmail();
			String username = user.getUsername();
			String password = user.getPassword();
			
			if (email != null && password != null) {
				User account = userService.findUserByEmail(email);
				
				if (account != null) {
					return isMatchesPassword(password, account.getPassword());
				}
			}
			
			if (username != null && password != null) {
				User account = userService.findUserByUsername(username);
				
				if (account != null) {
					return isMatchesPassword(password, account.getPassword());
				}
			}
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}