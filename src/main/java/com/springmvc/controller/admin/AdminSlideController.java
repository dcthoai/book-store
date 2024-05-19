package com.springmvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.ResponseJSON;
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

	@GetMapping(value = "/add")
	public ModelAndView addSlide() {
		ModelAndView mav = new ModelAndView("admin/add-slide");
		return mav;
	}
	
    @PostMapping(value = "/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("thumbnail") MultipartFile file,
                                               @RequestParam("title") String title,
                                               @RequestParam("description") String description,
                                               @RequestParam("slideProductLink") String slideProductLink) {
    	return null;
    }
}
