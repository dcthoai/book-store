package com.springmvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.user.impl.BookService;
import com.springmvc.service.user.impl.MediaService;

@Controller
public class ProductController {
	
	@Autowired
	private BookService bookService;
	@Autowired MediaService mediaService;
	
	@GetMapping("/product")
    public ModelAndView getProduct(@RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("user/product");
        mav.addObject("book", bookService.getBookById(id));
        mav.addObject("mediaService", mediaService);
        
        return mav;
    }
}
