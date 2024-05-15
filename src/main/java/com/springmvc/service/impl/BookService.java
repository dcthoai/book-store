package com.springmvc.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.BookDAO;
import com.springmvc.dto.BookDTO;
import com.springmvc.model.Author;
import com.springmvc.model.Book;
import com.springmvc.model.Category;
import com.springmvc.model.Language;
import com.springmvc.model.Publisher;
import com.springmvc.service.IBookService;

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
	public List<BookDTO> sortByNewest(List<BookDTO> listBooks){
		Comparator<BookDTO> comparator = new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO book1, BookDTO book2) {
                return book2.getCreatedDate().compareTo(book1.getCreatedDate());
            }
        };

        Collections.sort(listBooks, comparator);

        return listBooks;
	}

	@Override
	public List<BookDTO> sortByLowPrice(List<BookDTO> listBooks) {
		Comparator<BookDTO> comparator = new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO book1, BookDTO book2) {
                return Long.compare(book1.getSellPrice(), book2.getSellPrice());
            }
        };

        Collections.sort(listBooks, comparator);

        return listBooks;
	}

	@Override
	public List<BookDTO> sortByHighPrice(List<BookDTO> listBooks) {
		Comparator<BookDTO> comparator = new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO book1, BookDTO book2) {
                return Long.compare(book2.getSellPrice(), book1.getSellPrice());
            }
        };

        Collections.sort(listBooks, comparator);

        return listBooks;
	}

	@Override
	public List<BookDTO> sortByNameAZ(List<BookDTO> listBooks) {
		Comparator<BookDTO> comparator = new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO book1, BookDTO book2) {
                return book1.getTitle().compareTo(book2.getTitle());
            }
        };

        Collections.sort(listBooks, comparator);

        return listBooks;
	}

	@Override
	public List<BookDTO> sortByDiscount(List<BookDTO> listBooks) {
		Comparator<BookDTO> comparator = new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO book1, BookDTO book2) {
                return Float.compare(book2.getDiscount(), book1.getDiscount());
            }
        };

        Collections.sort(listBooks, comparator);

        return listBooks;
	}

	@Override
	public List<BookDTO> sortByReleaseDate(List<BookDTO> listBooks) {
		Comparator<BookDTO> comparator = new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO book1, BookDTO book2) {
                return book2.getReleaseDate().compareTo(book1.getReleaseDate());
            }
        };

        Collections.sort(listBooks, comparator);

        return listBooks;
	}

	@Override
	public List<BookDTO> sortByPurchases(List<BookDTO> listBooks) {
		Comparator<BookDTO> comparator = new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO book1, BookDTO book2) {
                return Integer.compare(book2.getPurchases(), book1.getPurchases());
            }
        };

        Collections.sort(listBooks, comparator);

        return listBooks;
	}
}
