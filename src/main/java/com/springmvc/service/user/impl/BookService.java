package com.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.BookDAO;
import com.springmvc.model.Author;
import com.springmvc.model.Book;
import com.springmvc.model.Category;
import com.springmvc.model.Language;
import com.springmvc.model.Publisher;
import com.springmvc.service.user.IBookService;

@Service
public class BookService implements IBookService{
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public int insertBook(Book book) {
		int bookId = bookDAO.insert(book);
		return bookId;
	}

	@Override
	public boolean updateBook(Book book) {
		int affectedRows = bookDAO.update(book);
		return affectedRows > 0;
	}

	@Override
	public boolean deleteBook(int id) {
		int affectedRows = bookDAO.delete(id);
		return affectedRows > 0;
	}
	
	@Override
	public Book getBookById(int id) {
		Book book = bookDAO.getById(id);
		return book;
	}
	
	@Override
	public String getBookAuthor(int authorId) {
		Author author = bookDAO.getBookAuthor(authorId);
		
		if (author != null)
			return author.getName();
		return "Không có thông tin";
	}
	
	@Override
	public String getBookCategory(int categoryId) {
		Category category = bookDAO.getBookCategory(categoryId);
		
		if (category != null)
			return category.getName();
		return "Không có thông tin";
	}
	
	@Override
	public String getBookLanguage(int languageId) {
		Language language = bookDAO.getBookLanguage(languageId);
		
		if (language != null) 
			return language.getName();
		return "Không có thông tin";
	}
	
	@Override
	public String getBookPublisher(int publisherId) {
		Publisher publisher = bookDAO.getBookPublisher(publisherId);
		
		if (publisher != null)
			return publisher.getName();
		return "Không có thông tin";
	}
	
	@Override
	public List<Book> getNewestBooks() {
		List<Book> listBooks = bookDAO.getNewestBooks();
		return listBooks;
	}

	@Override
	public List<Book> getLatestReleaseBooks() {
		List<Book> listBooks = bookDAO.getLatestReleaseBooks();
		return listBooks;
	}
	
	@Override
	public List<Book> filterBooks(int categoryId, int languageId, long minPrice, long maxPrice, int stars){
		
		return null;
	}
	
	@Override
	public List<Book> searchBook(String keyword){
		String s = "%" + keyword.trim() + "%";

		List<Book> listBooks = bookDAO.searchBook(s);
		return listBooks;
	}

	@Override
	public List<Book> sortByLowPrice(List<Book> listBooks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortByHighPrice(List<Book> listBooks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortByNameAZ(List<Book> listBooks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortByNameZA(List<Book> listBooks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortByReleaseDate(List<Book> listBooks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> sortByPurchases(List<Book> listBooks) {
		// TODO Auto-generated method stub
		return null;
	}
}