package com.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.impl.BookDAO;
import com.springmvc.model.Book;
import com.springmvc.service.user.IBookService;

@Service
public class BookService implements IBookService{
	@Autowired
	BookDAO bookDAO;

	
}