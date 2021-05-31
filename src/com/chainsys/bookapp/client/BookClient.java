package com.chainsys.bookapp.client;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.bookapp.exception.BookNotFoundException;
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
			System.out.println("Find All Books");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
			
		case 2:
			System.out.println("Find the Book By Id");
			System.out.println("Enter the Book Id");
			id = scanner.nextInt();
			try {
				book book = service.findById(id);
				System.out.println(book);
			} catch (BookNotFoundException e) {
			}
			break;
			
		case 3:
			System.out.println("Find the Book By Name");
			System.out.println("Enter the Book Name");
			String name = scanner.next();
			try {
				book book = service.findByName(name);
				System.out.println(book);
			} catch (BookNotFoundException e) {
			}
			break;
			
		case 4:
			System.out.println("Find the Book By Date");
			try {
			 	date = "06/07/2020";
				dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				book book=service.findByDate(LocalDate.parse(date,dateFormat));
				System.out.println(book);
			} catch (BookNotFoundException e) {
			}
			break;
			
		case 5:
			System.out.println("Deleting a Book");
			System.out.println("Enter the Book Id");
			id = scanner.nextInt();
			try {
				service.delete_id(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (BookNotFoundException e) {
			}
			
		case 6:
			System.out.println("Deleting a Book");
			System.out.println("Enter the Book name");
			name = scanner.next();
			try {
				service.delete_name(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (BookNotFoundException e) {
			}
			
		case 7:
			System.out.println("Deleting a Product");
			try {
				 	date = "06/07/2020";
					dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					service.delete_date(LocalDate.parse(date,dateFormat));
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (BookNotFoundException e) {
			}
			
			
		default:
			break;
		}
		scanner.close();
		
	}

}
