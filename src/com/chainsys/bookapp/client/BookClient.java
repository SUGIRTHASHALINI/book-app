package com.chainsys.bookapp.client;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.bookapp.model.book;
import com.chainsys.bookapp.service.bookService;
import com.chainsys.bookapp.service.bookServiceImpl;


public class BookClient {
	public static void main(String[] args) {
		Set<book> productSet;
		bookService service = new bookServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		default:
			break;
		}
		scanner.close();
		
	}

}
