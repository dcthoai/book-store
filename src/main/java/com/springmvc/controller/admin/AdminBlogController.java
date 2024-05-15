package com.springmvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.impl.BlogService;
import com.springmvc.service.impl.CustomerService;

@Controller
@RequestMapping(value = "/admin/dashboard/blog")
public class AdminBlogController {
	
	@Autowired 
	private CustomerService customerService;
	@Autowired 
	private BlogService blogService;
	
	@GetMapping(value = "")
	public ModelAndView blog() {
		ModelAndView mav = new ModelAndView("admin/blog");
		mav.addObject("customerService", customerService); 
		mav.addObject("blogs", blogService.getAllBlogs());
		  
		return mav; 
	}
}
