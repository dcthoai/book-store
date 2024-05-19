package com.springmvc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.IBookDAO;
import com.springmvc.mapper.MapperBook;
import com.springmvc.mapper.MapperCategory;
import com.springmvc.mapper.MapperLanguage;
import com.springmvc.model.Book;
import com.springmvc.model.Category;
import com.springmvc.model.Language;

@Repository 
public class BookDAO extends AbstractDAO<Book> implements IBookDAO{

	@Override
	public int insert(Book book) {
		String sql = "INSERT INTO books ("
			    	+ "title, description, size, author, publisher, "
			    	+ "rate, languageid, categoryid, thumbnailid, "
			    	+ "pages, weight, purchases, stock, price, "
			    	+ "discount, releasedate, createdby) "
			    	+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		
		int bookId = executeInsert(sql, book.getTitle(),
										book.getDescription(),
										book.getSize(),
										book.getAuthor(),
										book.getPublisher(),
										book.getRate(),
										book.getLanguageId(),
										book.getCategoryId(),
										book.getThumbnailId(),
										book.getPages(),
										book.getWeight(),
										book.getPurchases(),
										book.getStock(),
										book.getPrice(),
										book.getDiscount(),
										book.getReleaseDate(),
										book.getCreatedBy());
		
		return bookId;
	}

	@Override
	public int update(Book book) {
		String sql = "UPDATE `bookstore`.`book` SET "
						+ "title = ?, description = ?, size = ?, author = ?, publisher = ?, "
				    	+ "rate = ?, languageid = ?, categoryid = ?, thumbnailid = ?, "
				    	+ "pages = ?, weight = ?, purchases = ?, stock = ?, price + ?, "
				    	+ "discount = ?, releasedate = ?, modifiedBy = ? "
						+ "WHERE (`id` = ?)";
		
		int affectedRows = executeInsert(sql, book.getTitle(),
												book.getDescription(),
												book.getSize(),
												book.getAuthor(),
												book.getPublisher(),
												book.getRate(),
												book.getLanguageId(),
												book.getCategoryId(),
												book.getThumbnailId(),
												book.getPages(),
												book.getWeight(),
												book.getPurchases(),
												book.getStock(),
												book.getPrice(),
												book.getDiscount(),
												book.getReleaseDate(),
												book.getModifiedBy(),
												book.getId());
		return affectedRows;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM `bookstore`.`book` WHERE (`id` = ?)";
		
		int affectedRows = executeUpdate(sql, id);
		return affectedRows;
	}
	
	@Override
	public Book getById(int id) {
		String sql = "SELECT * FROM `bookstore`.`book` WHERE (`id` = ?)";
		
		List<Book> listBooks = executeQuery(sql, new MapperBook(), id);
		return listBooks.isEmpty() ? null : listBooks.get(0);
	}

	@Override
	public List<Book> getNewestBooks() {
		String sql = "SELECT * FROM `bookstore`.`book` ORDER BY `createdDate` DESC LIMIT 36";
		
		List<Book> listBooks = executeQuery(sql, new MapperBook());
		return listBooks;
	}
	
	public List<Book> getLatestReleaseBooks(){
		String sql = "SELECT * FROM `bookstore`.`book` ORDER BY `releaseDate` DESC LIMIT 36";
		
		List<Book> listBooks = executeQuery(sql, new MapperBook());
		return listBooks;
	}

	@Override
	public Category getBookCategory(int categoryId) {
		String sql = "SELECT * FROM `bookstore`.`category` WHERE (`id` = ?)";
		
		List<Category> listCategories = _jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			    public void setValues(PreparedStatement preparedStatement) throws SQLException {
			        preparedStatement.setInt(1, categoryId);
			    }
			    
			}, new MapperCategory());
		
		return listCategories.isEmpty() ? null : listCategories.get(0);
	}

	@Override
	public Language getBookLanguage(int languageId) {
		String sql = "SELECT * FROM `bookstore`.`language` WHERE (`id` = ?)";
		
		List<Language> listLanguages = _jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			    public void setValues(PreparedStatement preparedStatement) throws SQLException {
			        preparedStatement.setInt(1, languageId);
			    }
			    
			}, new MapperLanguage());
		
		return listLanguages.isEmpty() ? null : listLanguages.get(0);
	}
	
	@Override
	public List<Book> searchBook(String keyword){
		String sql = "SELECT * FROM `bookstore`.`book` WHERE (`title` LIKE ?)";
		
		List<Book> listBooks = executeQuery(sql, new MapperBook(), keyword);
		
		return listBooks;
	}

	@Override
	public List<Book> getRandomBook() {
		String sql = "SELECT * FROM `bookstore`.`book` ORDER BY RAND() LIMIT 6";
		
		List<Book> listBooks = executeQuery(sql, new MapperBook());
		
		return listBooks;
	}
}