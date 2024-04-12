package com.springmvc.service.user;

import java.util.List;

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
	
	public List<Book> sortByLowPrice(List<Book> listBooks);
	public List<Book> sortByHighPrice(List<Book> listBooks);
	public List<Book> sortByNameAZ(List<Book> listBooks);
	public List<Book> sortByNameZA(List<Book> listBooks);
	public List<Book> sortByReleaseDate(List<Book> listBooks);
	public List<Book> sortByPurchases(List<Book> listBooks);
}