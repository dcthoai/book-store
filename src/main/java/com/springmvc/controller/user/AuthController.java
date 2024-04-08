package com.springmvc.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.Customer;
import com.springmvc.model.UserCustom;
import com.springmvc.security.UserAuthenticationRequest;
import com.springmvc.service.user.impl.CustomerService;
import com.springmvc.service.user.impl.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
    
	@Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserAuthenticationRequest user) {
    	try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication authenticated = authenticationManager.authenticate(authentication);
            
            return ResponseEntity.ok().body(new JSONObject().put("success", true).toString());
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JSONObject()
                    .put("success", false)
                    .put("message", "Invalid username or password")
                    .toString());
        } catch (LockedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JSONObject()
                    .put("success", false)
                    .put("message", "Account locked")
                    .toString());
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONObject()
                    .put("success", false)
                    .put("message", "Server error")
                    .toString());
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody String jsonString) {
    	JSONObject userData = new JSONObject(jsonString);
    	
    	// Check data format from client
        if (!userData.has("username") || !userData.has("email") || !userData.has("password")) {
            return ResponseEntity.badRequest().body(new JSONObject()
                .put("success", false)
                .put("message", "Missing required data attributes from client")
                .toString());
        }
	        
        try {
        	String username = userData.getString("username");
        	String email = userData.getString("email");
        	String password = userData.getString("password");
        	String encodedPassword = passwordEncoder.encode(password);
        	
			boolean isExists = userService.isExistCustomerOrUser(username, email);
			
			if(isExists) {
				return ResponseEntity.badRequest().body(new JSONObject()
    	                .put("success", false)
    	                .put("message", "User is exists!")
    	                .toString());
			} else {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				
				UserCustom user = new UserCustom(username, encodedPassword, authorities, true, true, true, true);
				
				int userId = userService.insertUserCustom(user);
				
				if(userId > 0) {
					Customer customer = new Customer();
					customer.setUserId(userId);
					customer.setEmail(email);
					customer.setCreatedBy(username);
					
					int customerId = customerService.insertCustomer(customer);
					
					if(customerId > 0)
						return ResponseEntity.ok().body(new JSONObject().put("success", true).toString());
					else
						return ResponseEntity.badRequest().body(new JSONObject()
		    	                .put("success", false)
		    	                .put("message", "Register failure! Can not create a customer account.")
		    	                .toString());
				} else {
					return ResponseEntity.badRequest().body(new JSONObject()
	    	                .put("success", false)
	    	                .put("message", "Register failure! Can not save user to database.")
	    	                .toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body(new JSONObject()
	                .put("success", false)
	                .put("message", "Exception when checking data user!")
	                .toString());
		}
    }
}
