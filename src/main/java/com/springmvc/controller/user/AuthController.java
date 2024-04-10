package com.springmvc.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.springmvc.firebase.FirebaseService;
import com.springmvc.model.Customer;
import com.springmvc.model.UserCustom;
import com.springmvc.security.JwtTokenProvider;
import com.springmvc.security.UserAuthenticationRequest;
import com.springmvc.service.user.impl.CustomerService;
import com.springmvc.service.user.impl.UserService;

import io.jsonwebtoken.JwtException;

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
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private FirebaseService firebaseService;
	
	public void createSession(String username, HttpServletRequest request) {
		UserCustom user = userService.getUserByUsername(username);
        Customer customer = customerService.getCustomerByUserId(user.getUserId());

        // Return the current session or create a new one if it doesn't exist
        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("isUserAuthenticated", true);
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("customerId", customer.getId());
        
        System.out.println("Authenticated successful!");
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
            
            return ResponseEntity.ok().body(new JSONObject().put("success", true).toString());         	
        } else {
        	return ResponseEntity.badRequest().body(new JSONObject()
            		.put("success", false)
            		.put("message", "Can not logged out your account!")
            		.toString());
        }
    }
        
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader(name = "Authorization") String tokenRequest, 
								    		HttpServletRequest request){
    	
    	if (tokenRequest != null && tokenRequest.startsWith("Bearer ")) {
    		tokenRequest = tokenRequest.substring(7);
    		
			if (tokenRequest.isEmpty()) {
				return ResponseEntity.badRequest().body(new JSONObject()
						.put("success", false)
						.put("message", "NOT FOUND! Can not found a token.")
						.toString());
				
			} else {
				
				try {
					String username = jwtTokenProvider.getUsernameFromToken(tokenRequest);
		    		
		    		if (username == null || username.isEmpty()) {
		    			return ResponseEntity.badRequest().body(new JSONObject()
		    							.put("success", false)
		    							.put("message", "Invalid token! Missing user data.")
		    							.toString());
		    			
		    		} else {
		    			
		    			CompletableFuture<String> getUserToken = firebaseService.getTokenByUsername(username);
						String userToken = getUserToken.get();
						
						if (userToken != null && userToken.equals(tokenRequest)) {
							boolean isValid = jwtTokenProvider.validateToken(tokenRequest);
							
							if(isValid) {
								// Save user authentication state in current session
								createSession(username, request);
								
								return ResponseEntity.ok().body(new JSONObject().put("success", true).toString());
							} else {
								return ResponseEntity.ok().body(new JSONObject()
										.put("success", false)
										.put("message", "Invalid token! Can not authenticate user data.")
										.toString());
							}
						} else {
							return ResponseEntity.badRequest().body(new JSONObject()
	    							.put("success", false)
	    							.put("message", "Invalid token! Can not found user.")
	    							.toString());
						}
		    		}
		    		
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JSONObject()
							.put("success", false)
							.put("message", "Server error! Can not decode token.")
							.toString());
				}
			}
			
		}
		
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONObject()
				.put("success", false)
				.put("message", "Request is empty!")
				.toString());
    }
}
