package com.springmvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.User;
import com.springmvc.service.user.impl.UserService;

@Controller("userController")
public class UserContronller {
	
	@Autowired
    private UserService userService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }

        try {
            userService.insertUser(user); 
            return ResponseEntity.ok("Đăng ký thành công!");
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi đăng ký người dùng!");
        }
    }
    
    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public ResponseEntity<?> signIn(@RequestBody User user, BindingResult result){
    	if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid user data");
        }
    	
    	try {
    		
    		
    		return ResponseEntity.ok("Đăng nhập thành công!");
		} catch (Exception e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đăng nhập không thành công!");
        }
    }
}
