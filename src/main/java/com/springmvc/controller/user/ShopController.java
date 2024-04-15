package com.springmvc.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springmvc.dto.BookDTO;
import com.springmvc.model.Book;
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
	
	@GetMapping(value = "/shop/search")
	public ResponseEntity<?> filterProduct(@RequestParam("name") String keyword){

		List<Book> listBooks = bookService.searchBook(keyword);
		List<BookDTO> listBookDTOs = new ArrayList<BookDTO>();
		
		for (Book book : listBooks) {
			BookDTO bookDTO = new BookDTO();
			
			bookDTO.setId(book.getId());
			bookDTO.setTitle(book.getTitle());
			bookDTO.setThumbnailPath(mediaService.getMediaById(book.getThumbnailId()).getPath());
			bookDTO.setCost(book.getPrice());
			bookDTO.setSellPrice(book.getSellPrice());
			bookDTO.setDiscount(book.getDiscount());
			bookDTO.setRate(book.getRate());
			bookDTO.setPurchases(book.getPurchases());
			
			listBookDTOs.add(bookDTO);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(listBookDTOs);
		
		// Use UTF-8 to transmit data
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
	}
}