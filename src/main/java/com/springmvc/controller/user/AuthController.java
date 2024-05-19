package com.springmvc.controller.user;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.Cart;
import com.springmvc.model.ResponseJSON;
import com.springmvc.model.UserCustom;

import com.springmvc.security.JwtTokenProvider;
import com.springmvc.security.UserRequest;
import com.springmvc.service.impl.CartService;
import com.springmvc.service.impl.CustomUserDetailsService;

@RestController
public class AuthController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CartService cartService;
    
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody String jsonString) {
    	JSONObject userData = new JSONObject(jsonString);
    	
    	// Check data format from client
        if (!userData.has("username") || !userData.has("email") || !userData.has("password")) {
            return ResponseJSON.badRequest("Missing required data attributes from client!");
        }
	        
        try {
        	String username = userData.getString("username");
        	String email = userData.getString("email");
        	String password = userData.getString("password");
        	
        	if (customUserDetailsService.existUser(username, email)) {
        		return ResponseJSON.badRequest("User has already exist!");
			} else {
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				
				UserCustom userDetails = new UserCustom(username, password, authorities, true, true, true, true);
				userDetails.setCreatedBy(username);
				userDetails.setEmail(email);
				userDetails.setRole("ROLE_USER");
				
				int userId = customUserDetailsService.insert(userDetails);
				
				if(userId > 0) {
					Cart cart = new Cart();
					cart.setUserId(userId);
					cart.setQuantity(0);
					cart.setCreatedBy(username);
					
					int cartId = cartService.insertCart(cart);
					
					if (cartId > 0)
						return ResponseJSON.ok("Register success!");
					return ResponseJSON.serverError("Register failure! Can not create a cart");
				}
					
				return ResponseJSON.serverError("Register failure! Can not save user to database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseJSON.serverError("Register failure! Server error.");
		}
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest user, 
    									HttpServletRequest request,
    									HttpServletResponse response) {
    	
    	try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication authenticated = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authenticated);
            
            // Get user information after successful authentication
            UserCustom userAuthenticated = (UserCustom) authenticated.getPrincipal();
            String username = userAuthenticated.getUsername();

            // Generate a token to save authentication state
            String jwtToken = jwtTokenProvider.generateToken(userAuthenticated.getUsername(), " ");
            UserCustom userCustom = customUserDetailsService.getUserByUsername(username);
            userCustom.setToken(jwtToken);
            customUserDetailsService.update(userCustom);
            
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("isAuthenticated", true);
            
            System.out.println("Auth controller");

            // Sent token to client
            response.setHeader("Authorization", "Bearer " + jwtToken);
   
            return ResponseJSON.ok("Login success!");
        } catch (BadCredentialsException e) {
        	return ResponseJSON.badRequest("Invalid username or password!");
        } catch (LockedException e) {
        	return ResponseJSON.accessDenied("Account has been locked!");
        } catch (AuthenticationException e) {
        	return ResponseJSON.serverError("Server error");
        }
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(name = "Authorization") String tokenRequest, 
						    		HttpServletRequest request, 
						    		HttpServletResponse response) {
        
    	HttpSession session = request.getSession(false);
        	
        if (session != null) {
        	String username = (String) session.getAttribute("username");
        	UserCustom user = customUserDetailsService.getUserByUsername(username);
        	user.setToken(null);
        	customUserDetailsService.update(user);
        	
        	System.out.println("Logout session is not null");
        	
            response.setHeader("Authorization", "");
            session.invalidate();
            SecurityContextHolder.getContext().setAuthentication(null);
            
            return ResponseJSON.ok("Logout success!");
        } else {
        	return ResponseJSON.badRequest("Can not logged out your account!");
        }
    }
        
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader(name = "Authorization") String tokenRequest, 
								    		HttpServletRequest request){
    	
    	if (tokenRequest != null && tokenRequest.startsWith("Bearer ")) {
    		tokenRequest = tokenRequest.substring(7);
    		
			if (tokenRequest.isEmpty()) {
				return ResponseJSON.notFound("Token not found");
				
			} else {
				
				try {
					String username = jwtTokenProvider.getUsernameFromToken(tokenRequest);
		    		if (username != null && jwtTokenProvider.validateToken(tokenRequest)) {
		    			HttpSession session = request.getSession(true);
		                session.setAttribute("username", username);
		                session.setAttribute("isAuthenticated", true);
		    		
		    			return ResponseJSON.ok("Authenticated success");
		    		}
		    		
		    		return ResponseJSON.badRequest("Invalid token! Missing user data.");
		    		
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseJSON.serverError("Server error! Can not decode token.");
				}
			}
		}
		
    	return ResponseJSON.notFound("Empty request!");
    }
}
