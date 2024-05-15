package com.springmvc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Book;
import com.springmvc.service.impl.BookService;
import com.springmvc.service.impl.MediaService;

@Controller
@RequestMapping(value = "/admin/dashboard")
public class AdminProductController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired 
	private MediaService mediaService;

	@GetMapping(value = "/product/add")
	public ModelAndView addBook() {
		ModelAndView mav = new ModelAndView("admin/add-book");
		
		return mav;
	}
	
	@GetMapping(value = "/product/edit")
	public ModelAndView editBook(@RequestParam("id") Integer bookId) {
		ModelAndView mav = new ModelAndView("admin/edit-book");
		
		if (bookId != null && bookId > 0) {
			Book book = bookService.getBookById(bookId);
			mav.addObject("book", book);
			mav.addObject("mediaService", mediaService);
			mav.addObject("bookService", bookService);
		}
		
		return mav;
	}
	
	@PostMapping(value = "/product/delete")
	public ResponseEntity<?> deleteBook() {
		
		return null;
	}
}
