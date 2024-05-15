package com.springmvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.impl.SlideService;

@Controller
@RequestMapping(value = "/admin/dashboard/slide")
public class AdminSlideController {
	
	@Autowired
	private SlideService slideService;
	
	@GetMapping(value = "")
	public ModelAndView slide() {
		ModelAndView mav = new ModelAndView("admin/slide");
		mav.addObject("slides", slideService.getAllSlides());
		return mav;
	}

	@GetMapping(value = "/add-slide")
	public ModelAndView addSlide() {
		ModelAndView mav = new ModelAndView("admin/add-slide");
		
		return mav;
	}
}
