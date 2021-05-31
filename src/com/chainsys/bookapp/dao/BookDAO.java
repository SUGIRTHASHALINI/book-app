package com.chainsys.bookapp.dao;


import java.time.LocalDate;
import java.util.Set;

import com.chainsys.bookapp.model.book;


public interface BookDAO {
	Set<book> findAll();
	
	book findById(int id);
	
	book findByName(String name);
	
	book findByDate(LocalDate publishing_date);
	
	void delete_id(int id);
	
	void delete_date(LocalDate publishing_date);
	
	void delete_name(String name);

}
