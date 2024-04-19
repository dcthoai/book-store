package com.springmvc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("adminHomeController")
public class HomeController {
	
	@GetMapping(value = "/admin")
	public ModelAndView loginAdmin() {
		ModelAndView mav = new ModelAndView("admin/index");
		
		return mav;
	}
	
	@GetMapping(value = "/admin/dashboard")
	public ModelAndView dashboard() {
		ModelAndView mav = new ModelAndView("admin/dashboard");
		
		return mav;
	}
}