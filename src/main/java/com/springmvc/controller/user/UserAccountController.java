package com.springmvc.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UserCustom;
import com.springmvc.service.impl.CustomUserDetailsService;

@Controller
@RequestMapping(value = "/account")
public class UserAccountController {
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@GetMapping
	public ModelAndView accountPage(HttpServletRequest request) {
		ModelAndView mav;
		
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				String username = (String) session.getAttribute("username");
				UserCustom user = userService.getUserByUsername(username);
				
				if (user != null) {
					mav = new ModelAndView("user/account");
					mav.addObject("user", user);
					
					return mav;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
