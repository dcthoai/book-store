package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IBookDAO;
import com.springmvc.model.Book;

@Repository 
public class BookDAO extends AbstractDAO<Book> implements IBookDAO{

	@Override
	public int insert(Book t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Book t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Book getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getNewestBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksByLanguage(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksUnderPrice(long price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksOverPrice(long price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooksBetweenPrice(long minPrice, long maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}
}