package com.chainsys.bookapp.dao;

import java.util.Set;

import com.chainsys.bookapp.model.book;

public interface BookDAO {
	Set<book> findAll();

}
