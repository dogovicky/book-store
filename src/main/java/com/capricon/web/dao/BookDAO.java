package com.capricon.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.capricon.web.model.Book;

public class BookDAO {
	
	// Method to save book to database
	public static boolean saveBook(Book book) {
		String sql = "INSERT INTO books (title, author, isbn, price) VALUES (?, ?, ?, ?)";
		try {
			Connection conn = DataDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getIsbn());
			statement.setString(4, book.getPrice());
			
			int result = statement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
            System.err.println("Error saving book: " + e.getMessage());
		}
		return false;
	}

}
