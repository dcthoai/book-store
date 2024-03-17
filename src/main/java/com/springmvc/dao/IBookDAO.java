package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Book;

public interface IBookDAO extends IGenericDAO<Book>{
	Book getProductById(long id);
	List<Book> getProductNewUpdate();
	List<Book> getProductByCategory(int categoryId);
	List<Book> getProductByAuthor(String author);
	List<Book> getProductByPublisher(String publisher);
	List<Book> getProductByLanguage(String language);
	List<Book> getProductUnderPrice(long price);
	List<Book> getProductOverPrice(long price);
	List<Book> getProductBetweenPrice(long minPrice, long maxPrice);
}