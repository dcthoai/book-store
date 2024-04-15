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
	
	@Autowired 
	private MediaService mediaService;
	
	private List<BookDTO> listBookDTOs = new ArrayList<BookDTO>();
	
	@GetMapping(value = "/shop")
	public ModelAndView shop() {
		ModelAndView mav = new ModelAndView("user/shop");
		
		return mav;
	}
	
	@GetMapping(value = "/shop/get")
	public ResponseEntity<?> getNewBooks() {
		List<Book> listBooks = bookService.getNewestBooks();
		listBookDTOs.clear();
		
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
			bookDTO.setReleaseDate(book.getReleaseDate());
			bookDTO.setCreatedDate(book.getCreatedDate());
			
			listBookDTOs.add(bookDTO);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(listBookDTOs);
		
		// Use UTF-8 to transmit data
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
	}
	
	@GetMapping(value = "/shop/search")
	public ResponseEntity<?> searchProduct(@RequestParam("name") String keyword){

		List<Book> listBooks = bookService.searchBook(keyword);
		listBookDTOs.clear();
		
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
			bookDTO.setReleaseDate(book.getReleaseDate());
			bookDTO.setCreatedDate(book.getCreatedDate());
			
			listBookDTOs.add(bookDTO);
		}
		
		listBookDTOs = bookService.sortByNewest(listBookDTOs);
		Gson gson = new Gson();
		String json = gson.toJson(listBookDTOs);
		
		// Use UTF-8 to transmit data
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
	}
	
	@GetMapping(value = "/shop/search/sort")
	public ResponseEntity<?> filterProduct(@RequestParam("by") String sortBy){
		
		switch (sortBy) {
			case "newest":
				listBookDTOs = bookService.sortByNewest(listBookDTOs);
			    break;
	
			case "low-price":
				listBookDTOs = bookService.sortByLowPrice(listBookDTOs);
			    break;
	
			case "high-price":
				listBookDTOs = bookService.sortByHighPrice(listBookDTOs);
			    break;
	
			case "name":
				listBookDTOs = bookService.sortByNameAZ(listBookDTOs);
			    break;
	
			case "discount":
				listBookDTOs = bookService.sortByDiscount(listBookDTOs);
			    break;
	
			case "release-date":
				listBookDTOs = bookService.sortByReleaseDate(listBookDTOs);
			    break;
	
			case "purchases":
				listBookDTOs = bookService.sortByPurchases(listBookDTOs);
			    break;

			default:
				break;
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(listBookDTOs);
		
		// Use UTF-8 to transmit data
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
	}
}