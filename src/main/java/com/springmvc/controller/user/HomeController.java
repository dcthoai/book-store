package com.springmvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.user.impl.HomeService;
import com.springmvc.service.user.impl.MediaService;
import com.springmvc.service.user.impl.BookService;

@Controller("userHomeController")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	@Autowired 
	private MediaService mediaService;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView homepage() {
		
		ModelAndView mav = new ModelAndView("user/index");
		mav.addObject("slides", homeService.getAllSlides());
		mav.addObject("listTopBlogs", homeService.getTopBlog());
		mav.addObject("mediaService", mediaService);
		
		return mav;
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("user/about");
		return mav;
	}
}