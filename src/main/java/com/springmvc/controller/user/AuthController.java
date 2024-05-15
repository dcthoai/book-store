package com.springmvc.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.firebase.FirebaseService;

import com.springmvc.model.Cart;
import com.springmvc.model.Customer;
import com.springmvc.model.ResponseJSON;
import com.springmvc.model.UserCustom;

import com.springmvc.security.JwtTokenProvider;
import com.springmvc.security.UserAuthenticationRequest;
import com.springmvc.service.impl.CartService;
import com.springmvc.service.impl.CustomerService;
import com.springmvc.service.impl.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
    
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private FirebaseService firebaseService;
	
	public void createSession(String username, HttpServletRequest request) {
        // Return the current session or create a new one if it doesn't exist
        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("isUserAuthenticated", true);
        
        try {
        	UserCustom user = userService.getUserByUsername(username);
            Customer customer = customerService.getCustomerByUserId(user.getUserId());
            Cart cart = cartService.getCartByCustomerId(customer.getId());
            
            if (user != null)
            	session.setAttribute("userId", user.getUserId());
            
            if (customer != null)
            	session.setAttribute("customerId", customer.getId());
            
            if (cart != null) {
            	session.setAttribute("cartId", cart.getId());
            	session.setAttribute("quantityCart", cart.getQuantity());
            }
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody String jsonString) {
    	JSONObject userData = new JSONObject(jsonString);
    	
    	// Check data format from client
        if (!userData.has("username") || !userData.has("email") || !userData.has("password")) {
            return new ResponseJSON(false, "Missing required data attributes from client!").badRequest();
        }
	        
        try {
        	String username = userData.getString("username");
        	String email = userData.getString("email");
        	String password = userData.getString("password");
        	String encodedPassword = passwordEncoder.encode(password);
        	
			boolean isExists = userService.isExistCustomerOrUser(username, email);
			
			if(isExists) {
				return new ResponseJSON(false, "User has already exist!").badRequest();
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
					
					
					if(customerId > 0) {
						Cart cart = new Cart();
						cart.setCustomerId(customerId);
						cart.setQuantity(0);
						cart.setCreatedBy(username);
						
						int cartId = cartService.insertCart(cart);
						
						if (cartId > 0)
							return new ResponseJSON(true, "Successful").ok();
						return new ResponseJSON(false, "Register failure! Can not create a customer cart.").serverError();
					}

					return new ResponseJSON(false, "Register failure! Can not create a customer account.").badRequest();
				}
					
				return new ResponseJSON(false, "Register failure! Can not save user to database.").badRequest();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return new ResponseJSON(false, "Exception when checking data user!").badRequest();
		}
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserAuthenticationRequest user, 
    									HttpServletRequest request,
    									HttpServletResponse response) {
    	try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication authenticated = authenticationManager.authenticate(authentication);
            
            // Get user information after successful authentication
            UserCustom userAuthenticated = (UserCustom) authenticated.getPrincipal();
            String username = userAuthenticated.getUsername();

            // Save authentication state in current session
            createSession(username, request);
            // Generate a token to save authentication state
            String jwtToken = jwtTokenProvider.generateToken(userAuthenticated.getUsername(), " ");
            
            // Save user token to Firebase for authenticate on future visits
            firebaseService.saveUserToken(userAuthenticated.getUsername(), jwtToken);

            // Sent token to client
            response.setHeader("Authorization", "Bearer " + jwtToken);
   
            return new ResponseJSON(true, "Successful!").ok();
        } catch (BadCredentialsException e) {
        	return new ResponseJSON(false, "Invalid username or password!").unAuthorized();
        } catch (LockedException e) {
        	return new ResponseJSON(false, "Account has been locked!").accessDenied();
        } catch (AuthenticationException e) {
        	return new ResponseJSON(false, "Internal server error!").serverError();
        }
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(name = "Authorization") String tokenRequest, 
						    		HttpServletRequest request, 
						    		HttpServletResponse response) {
        
    	HttpSession session = request.getSession(false);
        	
        if (session != null) {
        	if (tokenRequest != null && tokenRequest.startsWith("Bearer ")) {
                tokenRequest = tokenRequest.substring(7);

                String username = jwtTokenProvider.getUsernameFromToken(tokenRequest);        	
	            firebaseService.deleteUserToken(username);
        	}
            response.setHeader("Authorization", "");
            session.invalidate();
            
            return new ResponseJSON(true, "Successful!").ok();       	
        } else {
        	return new ResponseJSON(false, "Can not logged out your account!").badRequest();
        }
    }
        
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader(name = "Authorization") String tokenRequest, 
								    		HttpServletRequest request){
    	
    	if (tokenRequest != null && tokenRequest.startsWith("Bearer ")) {
    		tokenRequest = tokenRequest.substring(7);
    		
			if (tokenRequest.isEmpty()) {
				return new ResponseJSON(false, "Not found token!").notFound();
				
			} else {
				
				try {
					String username = jwtTokenProvider.getUsernameFromToken(tokenRequest);
		    		
		    		if (username == null || username.isEmpty()) {
		    			return new ResponseJSON(false, "Invalid token! Missing user data.").badRequest();
		    		} else {
		    			
		    			CompletableFuture<String> getUserToken = firebaseService.getTokenByUsername(username);
						String userToken = getUserToken.get();
						
						if (userToken != null && userToken.equals(tokenRequest)) {
							boolean isValid = jwtTokenProvider.validateToken(tokenRequest);
							
							if(isValid) {
								// Save user authentication state in current session
								createSession(username, request);
								
								return new ResponseJSON(true, "Successful!").ok();
							} else {
								return new ResponseJSON(false, "Invalid token! Can not authenticate user data.").ok();
							}
							
						} else {
							return new ResponseJSON(false, "Invalid token! Can not found user.").badRequest();
						}
		    		}
		    		
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseJSON(false, "Server error! Can not decode token.").serverError();
				}
			}
			
		}
		
    	return new ResponseJSON(false, "Empty request!").notFound();
    }
}
