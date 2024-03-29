package com.springmvc.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("userBlogController")
public class BlogController {
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView blog() {
		ModelAndView mav = new ModelAndView("user/blog");
		return mav;
	}
}