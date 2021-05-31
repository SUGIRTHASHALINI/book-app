package com.chainsys.bookapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.bookapp.model.book;




public class bookDAOImpl implements BookDAO{
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<book> bookSet;
	private static ArrayList<String> namelist;
	private static ArrayList<Integer> idlist;
	public bookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:DBEBS12", "apps", "apps");
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
	public List<String> findAllName() {
		try {
			pstmt = con.prepareStatement("select name from book_2610");
			rs = pstmt.executeQuery();
			 namelist = new ArrayList<>();
			while (rs.next()) {
				namelist.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return namelist;
	}
	
	@Override
	public List<Integer> findAllId() {
		try {
			pstmt = con.prepareStatement("select id from book_2610");
			rs = pstmt.executeQuery();
			 idlist = new ArrayList<>();
			while (rs.next()) {
				idlist.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idlist;
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
			pstmt = con.prepareStatement("select * from BOOK_2610 where publishing_date=?");
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
	
	@Override
	public void delete_id(int id) {
		try {
			pstmt = con.prepareStatement("delete BOOK_2610 where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void delete_name(String name) {
		try {
			pstmt = con.prepareStatement("delete BOOK_2610 where name=?");
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}	
	@Override
	public void delete_date(LocalDate publishing_date) {
		try {
			pstmt = con.prepareStatement("delete BOOK_2610 where publishing_date=?");
			pstmt.setDate(1, Date.valueOf(publishing_date));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
}
