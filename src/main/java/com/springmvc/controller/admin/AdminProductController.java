package com.springmvc.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.BookRequest;
import com.springmvc.model.Book;
import com.springmvc.model.Media;
import com.springmvc.model.ResponseJSON;
import com.springmvc.service.impl.BookService;
import com.springmvc.service.impl.MediaFileService;
import com.springmvc.service.impl.MediaService;

@Controller
@RequestMapping(value = "/admin/dashboard/product")
public class AdminProductController {
	
	@Autowired
	private MediaFileService mediaFileService;
	
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
	
	@PostMapping(value = "/insert")
	public ResponseEntity<?> addNewBook(HttpServletRequest request, @RequestParam("title") String title,
										@ModelAttribute BookRequest bookRequest) throws IOException {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return ResponseJSON.badRequest("You cannot does this action");
				
				System.out.println(bookRequest.getTitle());
				System.out.println(title);
				
				if (mediaFileService.isUploadFile(bookRequest.getThumbnail())) {
					Media media = new Media();
					String imageUrl = mediaFileService.saveFile(bookRequest.getThumbnail());
				
					if (imageUrl != null) {
						media.setPath(imageUrl);
						int thumbnailId = mediaService.insertMedia(media);

						Book book = bookService.transferRequest(bookRequest);
						book.setThumbnailId(thumbnailId);
						book.setCreatedBy((String) session.getAttribute("username"));
						
						int bookId = bookService.insertBook(book);
						
						if (bookId > 0)
							return ResponseJSON.ok("Save book success");
						return ResponseJSON.badRequest("Missing data feild for this book");
					}
						
					return ResponseJSON.serverError("Cannot save image");
				}
				
				return ResponseJSON.badRequest("Missing thumbnail");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseJSON.badRequest("You cannot does this action");
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<?> updateBook(HttpServletRequest request, 
										@ModelAttribute BookRequest bookRequest) throws IOException {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				Book book = bookService.getBookById(bookRequest.getId());
				
				if (book == null)
					return ResponseJSON.badRequest("Data invalid");

				if (mediaFileService.isUploadFile(bookRequest.getThumbnail())) {
					Media media = new Media();
					String imageUrl = mediaFileService.saveFile(bookRequest.getThumbnail());
				
					if (imageUrl != null) {
						media.setPath(imageUrl);
						int thumbnailId = mediaService.insertMedia(media);
						
						Media oldImage = mediaService.getMediaById(book.getThumbnailId());
						
						if (oldImage != null) {
							mediaFileService.deleteFile(oldImage.getPath());
							mediaService.deleteMedia(book.getThumbnailId());
						}

						Book newBook = bookService.transferRequest(bookRequest);
						
						newBook.setId(book.getId());
						newBook.setThumbnailId(thumbnailId);
						newBook.setModifiedBy((String) session.getAttribute("username"));
						
						boolean isSuccess = bookService.updateBook(newBook);
						
						if (isSuccess)
							return ResponseJSON.ok("Save book success");
						return ResponseJSON.badRequest("Missing data feild for this book");
					}
						
					return ResponseJSON.serverError("Cannot save image");
				}
				
				return ResponseJSON.badRequest("Missing thumbnail");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseJSON.badRequest("You cannot have authorities");
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> deleteBook(HttpServletRequest request, @RequestParam("id") Integer bookId) {
		try {
			HttpSession session = request.getSession(false);
			
			if (session != null) {
				boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
				if (!isAdmin)
					return null;
				
				if (bookId != null && bookId > 0) {
					bookService.deleteBook(bookId);
						
					return ResponseJSON.ok("Delete book success");
				}
				
				return ResponseJSON.badRequest("Missing id book");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseJSON.serverError("Cannot delete this product");
		}
		
		return ResponseJSON.badRequest("You cannot have authorities");
	}
}
