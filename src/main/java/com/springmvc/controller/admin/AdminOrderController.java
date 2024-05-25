package com.springmvc.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.impl.CustomUserDetailsService;
import com.springmvc.service.impl.OrderService;

@Controller
@RequestMapping(value = "/admin/dashboard/order")
public class AdminOrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@GetMapping(value = {"", "/"})
	public ModelAndView order(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/order");
				mav.addObject("orders", orderService.getAllOrder());
				mav.addObject("userService", customUserDetailsService);
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@GetMapping(value = "update")
	public ModelAndView orderUpdate(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/update-order");
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
