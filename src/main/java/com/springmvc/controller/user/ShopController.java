package com.springmvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.user.impl.BookService;
import com.springmvc.service.user.impl.MediaService;

@Controller("userShopController")
public class ShopController {
	
	@Autowired
	private BookService bookService;
	@Autowired MediaService mediaService;
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ModelAndView shop() {
		ModelAndView mav = new ModelAndView("user/shop");
		mav.addObject("newestBooks", bookService.getNewestBooks());
		mav.addObject("mediaService", mediaService);
		return mav;
	}
}