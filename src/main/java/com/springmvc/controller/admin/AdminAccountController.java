package com.springmvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.impl.CustomerService;
import com.springmvc.service.impl.UserService;

@Controller
@RequestMapping(value = "/admin/dashboard/account")
public class AdminAccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "")
	public ModelAndView userAccount() {
		ModelAndView mav = new ModelAndView("admin/account");
		mav.addObject("accounts", userService.getAllUsers());
		mav.addObject("customerService", customerService);

		return mav;
	}
}
