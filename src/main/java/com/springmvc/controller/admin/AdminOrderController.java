package com.springmvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.impl.CustomerService;
import com.springmvc.service.impl.OrderService;

@Controller
@RequestMapping(value = "/admin/dashboard/order")
public class AdminOrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = {"", "/"})
	public ModelAndView order() {
		ModelAndView mav = new ModelAndView("admin/order");
		mav.addObject("orders", orderService.getAllOrder());
		mav.addObject("customerService", customerService);
		
		
		return mav;
	}
}
