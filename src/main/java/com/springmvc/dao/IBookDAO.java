package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Author;
import com.springmvc.model.Book;
import com.springmvc.model.Category;
import com.springmvc.model.Language;
import com.springmvc.model.Publisher;

public interface IBookDAO extends IGenericDAO<Book>{
	public List<Book> getNewestBooks();
	public List<Book> getLatestReleaseBooks();
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByPublisher(String publisher);
	
	public Author getBookAuthor(int authorId);
	public Category getBookCategory(int categoryId);
	public Language getBookLanguage(int languageId);
	public Publisher getBookPublisher(int publisherId);
}