package com.springmvc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.IBookDAO;
import com.springmvc.mapper.MapperBook;
import com.springmvc.model.Book;

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
}