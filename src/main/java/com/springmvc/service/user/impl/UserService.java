package com.springmvc.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.CustomerDAO;
import com.springmvc.dao.impl.UserCustomDAO;
import com.springmvc.model.Customer;
import com.springmvc.model.UserCustom;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserCustomDAO userCustomDAO;
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCustom user = userCustomDAO.getUserByUsername(username);
		
		if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

		return user;
	}
		
	public boolean isExistCustomerOrUser(String username, String email) {
		try {
			UserCustom user = userCustomDAO.getUserByUsername(username);
			Customer customer = customerDAO.getCustomerByEmail(email);
			
			if (customer != null || user != null)
				return true;
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int insertUserCustom(UserCustom user) {
		int userId = userCustomDAO.insert(user);
		
		return userId;
	}
}