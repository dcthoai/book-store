package com.springmvc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.IBookDAO;
import com.springmvc.mapper.MapperAuthor;
import com.springmvc.mapper.MapperBook;
import com.springmvc.mapper.MapperCategory;
import com.springmvc.mapper.MapperLanguage;
import com.springmvc.mapper.MapperPublisher;
import com.springmvc.model.Author;
import com.springmvc.model.Book;
import com.springmvc.model.Category;
import com.springmvc.model.Language;
import com.springmvc.model.Publisher;

@Repository 
public class BookDAO extends AbstractDAO<Book> implements IBookDAO{

	@Override
	public int insert(Book book) {
		String sql = "INSERT INTO `bookstore`.`book` "
						+ "(`title`, `description`, `size`, "
						+ "`authorId`, `publisherId`, `languageId`, `categoryId`, `voucherId`, `thumbnailId`, "
						+ "`pages`, `weight`, `price`, `discount`, `purchases`, `rate`, `releaseDate`, `createdBy`) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int bookId = executeInsert(sql, book.getTitle(),
										book.getDescription(),
										book.getSize(),
										book.getAuthorId(),
										book.getPublisherId(),
										book.getLanguageId(),
										book.getCategoryId(),
										book.getVoucherId(),
										book.getThumbnailId(),
										book.getPages(),
										book.getWeight(),
										book.getPrice(),
										book.getDiscount(),
										book.getPurchases(),
										book.getRate(),
										book.getReleaseDate(),
										book.getCreatedBy());
		return bookId;
	}

	@Override
	public int update(Book book) {
		String sql = "UPDATE `bookstore`.`book` SET "
						+ "`title` = ?, `description` = ?, `size` = ?, "
						+ "`authorId` = ?, `publisherId` = ?, `languageId` ?, `categoryId` = ?, `voucherId` = ?, `thumbnailId` = ?, "
						+ "`pages` = ?, `weight` = ?, `price` = ?, `discount` = ?, `purchases` = ?, `rate` = ?, "
						+ "`releaseDate` = ?, `modifiedBy` = ? "
						+ "WHERE (`id` = ?)";
		
		int affectedRows = executeInsert(sql, book.getTitle(),
											  book.getDescription(),
											  book.getSize(),
											  book.getAuthorId(),
											  book.getPublisherId(),
											  book.getLanguageId(),
											  book.getCategoryId(),
											  book.getVoucherId(),
											  book.getThumbnailId(),
											  book.getPages(),
											  book.getWeight(),
											  book.getPrice(),
											  book.getDiscount(),
											  book.getPurchases(),
											  book.getRate(),
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
	public List<Book> getBooksByAuthor(String authorId) {
		String sql = "SELECT * FROM `bookstore`.`book` WHERE (`authorId` = ?)";
		
		List<Book> listBooks = executeQuery(sql, new MapperBook(), authorId);
		return listBooks;
	}

	@Override
	public List<Book> getBooksByPublisher(String publisherId) {
		String sql = "SELECT * FROM `bookstore`.`book` WHERE (`publisherId` = ?)";
		
		List<Book> listBooks = executeQuery(sql, new MapperBook(), publisherId);
		return listBooks;
	}

	@Override
	public Author getBookAuthor(int authorId) {
		String sql = "SELECT * FROM `bookstore`.`author` WHERE (`id` = ?)";
		
		List<Author> listAuthors = _jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			    public void setValues(PreparedStatement preparedStatement) throws SQLException {
			        preparedStatement.setInt(1, authorId);
			    }
			    
			}, new MapperAuthor());
		
		return listAuthors.isEmpty() ? null : listAuthors.get(0);
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
	public Publisher getBookPublisher(int publisherId) {
		String sql = "SELECT * FROM `bookstore`.`publisher` WHERE (`id` = ?)";
		
		List<Publisher> listPublishers = _jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			    public void setValues(PreparedStatement preparedStatement) throws SQLException {
			        preparedStatement.setInt(1, publisherId);
			    }
			    
			}, new MapperPublisher());
		
		return listPublishers.isEmpty() ? null : listPublishers.get(0);
	}
}