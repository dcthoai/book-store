package com.springmvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.user.impl.HomeService;
import com.springmvc.service.user.impl.BookService;

@Controller("userHomeController")
public class HomeController {
	@Autowired
	HomeService homeService;
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView mav = new ModelAndView("user/index");
		mav.addObject("categories", homeService.getAllCategories());
		mav.addObject("slides", homeService.getAllSlides());
		return mav;
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView product() {
		ModelAndView mav = new ModelAndView("user/product");
		mav.addObject("books", bookService.getAllBooks());
		return mav;
	}
}