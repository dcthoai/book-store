package com.springmvc.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("userShopController")
public class ShopController {
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ModelAndView shop() {
		ModelAndView mav = new ModelAndView("user/shop");
		return mav;
	}
	
	@RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
	public ModelAndView shoppingCart() {
		ModelAndView mav = new ModelAndView("user/shopping-cart");
		return mav;
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView product() {
		ModelAndView mav = new ModelAndView("user/product");
		return mav;
	}
}
