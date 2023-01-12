package com.cognixia.jump.trackermenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.DAO.UserShow;
import com.cognixia.jump.connection.BetterConnectionManager;

public class JoinsQueries {
	public static void userShowArray(int userId) {
		String [][] userShows = null;
		
		final Connection conn = BetterConnectionManager.getConnection();
			try {
				PreparedStatement pstmt = conn.prepareStatement("select title, last_watched, episodes from user_show us join tv_show ts on ts.show_id = us.show_id where user_id = ?");
				pstmt.setInt(1, userId);

				ResultSet rs = pstmt.executeQuery();
			
				UserShow userShow = null;

				//While result set has data, get information from user_data table
				while(rs.next()) {
					int id = rs.getInt("user_id");
					int sId = rs.getInt("show_id");
					int episodes = rs.getInt("episodes");
					//Change to an array
					//userShow = new UserShow(id, sId, episodes);
				}
				rs.close();

			} catch (SQLException e) {
			
				System.out.println("UserShow with userid = " + userId + " not found.");
			}
		}
	
	public static void main(String[] args) {
		
	}
}
