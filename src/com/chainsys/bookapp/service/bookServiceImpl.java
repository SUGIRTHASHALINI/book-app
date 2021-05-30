package com.chainsys.bookapp.service;

import java.time.LocalDate;
import java.util.Set;

import com.chainsys.bookapp.dao.BookDAO;
import com.chainsys.bookapp.dao.bookDAOImpl;
import com.chainsys.bookapp.exception.BookNotFoundException;
import com.chainsys.bookapp.model.book;

public class bookServiceImpl implements bookService {
	private static BookDAO dao;

	public bookServiceImpl() {
		dao = new bookDAOImpl();
	}

	@Override
	public Set<book> findAll() {
		return dao.findAll();
	}
	
	@Override
	public book findById(int id) throws BookNotFoundException {
		book book = dao.findById(id);
		if (book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		} else {
			return book;
		}
	}
	
	@Override
	public book findByName(String name) throws BookNotFoundException {
		book book = dao.findByName(name);
		if (book == null) {
			throw new BookNotFoundException("Book name Not Found");
		} else {
			return book;
		}
	}
	
	@Override
	public book findByDate(LocalDate publishing_date) throws BookNotFoundException {
		book book = dao.findByDate( publishing_date);
		if (book == null) {
			throw new BookNotFoundException("Book  Not Found");
		} else {
			return book;
		}

	}


}
