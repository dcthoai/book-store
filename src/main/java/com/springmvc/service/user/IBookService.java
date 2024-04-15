package com.springmvc.service.user;

import java.util.List;

import com.springmvc.dto.BookDTO;
import com.springmvc.model.Book;

public interface IBookService {
	public int insertBook(Book book);
	public boolean updateBook(Book book);
	public boolean deleteBook(int id);
	public Book getBookById(int id);
	
	public String getBookAuthor(int authorId);
	public String getBookCategory(int categoryId);
	public String getBookLanguage(int languageId);
	public String getBookPublisher(int publisherId);
	
	public List<Book> getNewestBooks();
	public List<Book> getLatestReleaseBooks();
	public List<Book> filterBooks(int categoryId, int languageId, long minPrice, long maxPrice, int stars);
	public List<Book> searchBook(String keyword);
	
	public List<BookDTO> sortByNewest(List<BookDTO> listBooks);
	public List<BookDTO> sortByLowPrice(List<BookDTO> listBooks);
	public List<BookDTO> sortByHighPrice(List<BookDTO> listBooks);
	public List<BookDTO> sortByNameAZ(List<BookDTO> listBooks);
	public List<BookDTO> sortByDiscount(List<BookDTO> listBooks);
	public List<BookDTO> sortByReleaseDate(List<BookDTO> listBooks);
	public List<BookDTO> sortByPurchases(List<BookDTO> listBooks);
}