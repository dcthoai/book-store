package com.springmvc.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("userBlogController")
public class BlogController {
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog() {

		return "user/blog";
	}
}