package com.springmvc.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserCustom extends User{
	// Ensures consistency when serializing and deserializing objects of the Customer class
	private static final long serialVersionUID = 4954985107326310086L;
	
	// enabled: Status of the user account (enabled or not).
	// accountNonExpired: Status of the account (expired or not).
	// credentialsNonExpired: Status of the password (expired or not).
	// accountNonLocked: Status of the account (locked or not).
	// authorities: List of user roles
	
	private int userId;
	
	public UserCustom(String username, String password, 
						Collection<? extends GrantedAuthority> authorities,
						boolean enabled, 
						boolean accountNonExpired, 
						boolean credentialsNonExpired,
						boolean accountNonLocked) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
	
	public void setUserId(int id) {
		this.userId = id;
	}

	public int getUserId() {
		return userId;
	}
}