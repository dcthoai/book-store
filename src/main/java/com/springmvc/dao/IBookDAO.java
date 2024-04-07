package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Book;

public interface IBookDAO extends IGenericDAO<Book>{
	public List<Book> getNewestBooks();
	public List<Book> getLatestReleaseBooks();
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByPublisher(String publisher);
}