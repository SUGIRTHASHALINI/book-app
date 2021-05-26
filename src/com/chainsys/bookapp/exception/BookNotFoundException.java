package com.chainsys.bookapp.exception;

public class BookNotFoundException extends Exception{
	
	public BookNotFoundException(String message) {
		System.out.println(message);
	}

}
