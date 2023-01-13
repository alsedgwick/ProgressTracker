package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.BetterConnectionManager;

public class UserDAOSQL implements UserDAO{
	
	private Connection conn = BetterConnectionManager.getConnection();

	@Override
	public User getUserByUS(String username) {

		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from user_data where username = ?");
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();
			
			User user = null;

			//While result set has data, get information from user_data table
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("username");
				String password = rs.getString("user_password");
				user = new User(id, name, password);
			}
			rs.close();
			return user;

		} catch (SQLException e) {
			
			System.out.println("User with username = " + username + " not found.");
		}

		return null;
	}
	
	public List<User> getAllUsers() {
		try {
			// find all the users...
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user_data");
			
			List<User> userList = new ArrayList<User>();
		
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("user_password");

				User user = new User(id, username, password);
				userList.add(user);
			}
			return userList;
			
		} catch (SQLException e) {
			System.out.println("Could not retrieve list of users from database");
		}
		// return null just in case exception is thrown
		return null;
	}
	
}
