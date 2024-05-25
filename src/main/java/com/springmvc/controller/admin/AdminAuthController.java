package com.springmvc.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.ResponseJSON;
import com.springmvc.model.UserCustom;
import com.springmvc.security.JwtTokenProvider;
import com.springmvc.security.UserRequest;
import com.springmvc.service.impl.CustomUserDetailsService;

@Controller("adminAuthController")
@RequestMapping(value = "/admin")
public class AdminAuthController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
    
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@GetMapping
	public ModelAndView loginAdmin(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/index");

		return mav;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginAdmin(HttpServletRequest request, 
										HttpServletResponse response, 
										@RequestBody UserRequest userRequest) {
		
		try {
            UserCustom user = customUserDetailsService.getUserByUsername(userRequest.getUsername());
            
            if (user == null || !user.getRole().equals("ROLE_ADMIN"))
            	return ResponseJSON.badRequest("Cannot found your account or it is not authorized");
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword());
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
            session.setAttribute("isAdmin", true);

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
    public ResponseEntity<?> logout(HttpServletRequest request, 
						    		HttpServletResponse response) {
        
    	HttpSession session = request.getSession(false);
        	
        if (session != null) {
        	String username = (String) session.getAttribute("username");
        	UserCustom user = customUserDetailsService.getUserByUsername(username);
        	user.setToken(null);
        	customUserDetailsService.update(user);
        	
            response.setHeader("Authorization", "");
            session.invalidate();
            SecurityContextHolder.getContext().setAuthentication(null);
            
            return ResponseJSON.ok("Logout success!");
        } else {
        	return ResponseJSON.badRequest("Can not logged out your account!");
        }
    }
}