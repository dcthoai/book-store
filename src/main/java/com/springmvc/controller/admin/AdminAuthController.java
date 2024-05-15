package com.springmvc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("adminAuthController")
public class AdminAuthController {
	
	@GetMapping(value = "/admin")
	public ModelAndView loginAdmin() {
		ModelAndView mav = new ModelAndView("admin/index");
		
		return mav;
	}
}