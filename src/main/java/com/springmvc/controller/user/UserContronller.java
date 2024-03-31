package com.springmvc.controller.user;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.User;
import com.springmvc.service.user.impl.AuthService;

@Controller("userController")
public class UserContronller {
	
	@Autowired
	private AuthService authService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User user, BindingResult result) {
    	// Check for data format errors
    	if (result.hasErrors()) {
    		JSONObject error = new JSONObject();
			error.put("success", false);
			error.put("message", "Invalid user data!");
			
            return ResponseEntity.badRequest().body(error.toString());
        }

        try {
        	// Check if the account already exists in the database
        	boolean isExists = authService.isExistUser(user.getUsername(), user.getEmail());
    		
    		if (isExists) {
        		JSONObject error = new JSONObject();
    			error.put("success", false);
    			error.put("message", "User is already exists!");
    			
    			return ResponseEntity.status(HttpStatus.CONFLICT).body(error.toString());
        	} else {
        		// Create a new account if it doesn't exist yet
        		// Return id of user just created
        		int userId = authService.register(user);

        		if (userId > 0) {
        			return ResponseEntity.ok(new JSONObject().put("success", true).toString());
        		} else {
        			// Return error if user id is invalid
        			JSONObject error = new JSONObject();
        			error.put("success", false);
        			error.put("message", "Create account failure!" + userId);
        			
        			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.toString());
        		}
        	}
  //  		authService.register(user);
//        	return ResponseEntity.ok(new JSONObject().put("success", true).toString());
        	
        } catch (Exception e) {
        	e.printStackTrace();
        	
        	JSONObject error = new JSONObject();
			error.put("success", false);
			error.put("message", "Error exception when register! " + e.getMessage());

        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.toString());
        }
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user, BindingResult result){
    	// Check for data format errors
    	if (result.hasErrors()) {
    		JSONObject error = new JSONObject();
			error.put("success", false);
			error.put("message", "Invalid user data!");
			
            return ResponseEntity.badRequest().body(error.toString());
        }
    	
    	try {
    		boolean isExists = authService.isExistUser(user.getUsername(), user.getEmail());
    		
    		if (isExists) {
    			boolean loginSuccess = authService.login(user);
    			
    			if(loginSuccess) {
    				return ResponseEntity.ok(new JSONObject().put("success", true).toString());    				
    			} else {
    				JSONObject error = new JSONObject();
        			error.put("success", false);
        			error.put("message", "Login failure!");
        			
    				return ResponseEntity.status(HttpStatus.CONFLICT).body(error.toString());
    			}
    		} else {
    			JSONObject error = new JSONObject();
    			error.put("success", false);
    			error.put("message", "User is not exists");
    			
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.toString());
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			
			JSONObject error = new JSONObject();
			error.put("success", false);
			error.put("message", "Error exception when login! " + e.getMessage());
			
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.toString());
        }
    }
}