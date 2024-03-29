package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Book;

public interface IBookDAO extends IGenericDAO<Book>{
	public List<Book> getNewestBooks();
	public List<Book> getBooksByCategory(int categoryId);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByPublisher(String publisher);
	public List<Book> getBooksByLanguage(String language);
	public List<Book> getBooksUnderPrice(long price);
	public List<Book> getBooksOverPrice(long price);
	public List<Book> getBooksBetweenPrice(long minPrice, long maxPrice);
}