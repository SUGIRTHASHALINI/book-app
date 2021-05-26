package com.chainsys.bookapp.service;

import java.util.Set;

import com.chainsys.bookapp.dao.BookDAO;
import com.chainsys.bookapp.dao.bookDAOImpl;
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

}
