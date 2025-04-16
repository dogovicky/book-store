package com.capricon.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capricon.web.model.User;

public class UserDAO {
	
	public static boolean saveUser(User user) {
		String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
		try (
			Connection conn = DataDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)){
			
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			
			int result = statement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean loginUser(User user) {
        String sql = "SELECT password FROM users WHERE email = ?";

        try (Connection conn = DataDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getEmail());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    String enteredPassword = user.getPassword();

                    return storedPassword.equals(enteredPassword);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
