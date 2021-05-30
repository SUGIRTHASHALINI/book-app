package com.chainsys.bookapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.chainsys.bookapp.model.book;




public class bookDAOImpl implements BookDAO{
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<book> bookSet;
	public bookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Set<book> findAll() {
		try {
			pstmt = con.prepareStatement("select * from book_2610");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				book book = new book(rs.getInt("id"), rs.getString("name"),
						rs.getDate("publishing_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}
	
	@Override
	public book findById(int id) {
		book book = null;
		try {
			pstmt = con.prepareStatement("select * from BOOK_2610 where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new book(rs.getInt("id"), rs.getString("name"), rs.getDate("publishing_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public book findByName(String name) {
		book book = null;
		try {
			pstmt = con.prepareStatement("select * from BOOK_2610 where name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new book(rs.getInt("id"), rs.getString("name"), rs.getDate("publishing_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public book findByDate(LocalDate publishing_date) {
		book book = null;
		try {
			pstmt = con.prepareStatement("select * from BOOK_2610 where expiry_date=?");
			pstmt.setDate(1, Date.valueOf(publishing_date));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new book(rs.getInt("id"), rs.getString("name"), rs.getDate("publishing_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}
	
}
