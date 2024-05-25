package com.springmvc.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Book;
import com.springmvc.model.ResponseJSON;
import com.springmvc.service.impl.BookService;
import com.springmvc.service.impl.MediaService;

@Controller
@RequestMapping(value = "/admin/dashboard/product")
public class AdminProductController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired 
	private MediaService mediaService;

	@GetMapping(value = "/add")
	public ModelAndView addBook(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/add-book");
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping(value = "/edit")
	public ModelAndView editBook(@RequestParam("id") Integer bookId, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				ModelAndView mav = new ModelAndView("admin/edit-book");
				
				if (bookId != null && bookId > 0) {
					Book book = bookService.getBookById(bookId);
					mav.addObject("book", book);
					mav.addObject("mediaService", mediaService);
					mav.addObject("bookService", bookService);
				}
				
				return mav;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@PostMapping(value = "/delete")
	public ResponseEntity<?> deleteBook(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseJSON.badRequest("You cannot have authorities");
	}
}
