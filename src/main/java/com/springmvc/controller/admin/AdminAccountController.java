package com.springmvc.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.impl.CustomUserDetailsService;

@Controller
@RequestMapping(value = "/admin/dashboard/account")
public class AdminAccountController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@GetMapping(value = "")
	public ModelAndView userAccount(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/account");
				mav.addObject("users", customUserDetailsService.getAllUsers());
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
