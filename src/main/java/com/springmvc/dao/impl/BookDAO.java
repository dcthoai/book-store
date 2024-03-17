package com.springmvc.dao.impl;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.IBookDAO;
import com.springmvc.mapper.MapperBook;
import com.springmvc.model.Book;

@Repository 
public class BookDAO implements IBookDAO{
	@Autowired 
	public JdbcTemplate _jdbcTemplate;
	
	public List<Book> getAllBooks(){ 
		List<Book> listBooks = new ArrayList<Book>(); 
		String sql = "SELECT * FROM Book"; 
		listBooks = _jdbcTemplate.query(sql, new MapperBook());
		return listBooks;
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book getProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductNewUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductByLanguage(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductUnderPrice(long price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductOverPrice(long price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getProductBetweenPrice(long minPrice, long maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}
}