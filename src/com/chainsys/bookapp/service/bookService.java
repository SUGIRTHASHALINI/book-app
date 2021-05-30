package com.chainsys.bookapp.service;

import java.time.LocalDate;
import java.util.Set;

import com.chainsys.bookapp.exception.BookNotFoundException;
import com.chainsys.bookapp.model.book;

public interface bookService {
	Set<book> findAll();
	
	book findById(int id) throws BookNotFoundException;
	
	book findByName(String name) throws BookNotFoundException;
	
	book findByDate(LocalDate publishing_date) throws BookNotFoundException;

}
