package com.springmvc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("adminHomeController")
public class HomeController {
	
	@RequestMapping(value = {"/admin", "/admin/"}, method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView mav = new ModelAndView("admin/index");
		return mav;
	}
}