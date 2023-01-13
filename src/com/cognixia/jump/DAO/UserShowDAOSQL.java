package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.BetterConnectionManager;

public class UserShowDAOSQL implements UserShowDAO {
	private Connection conn = BetterConnectionManager.getConnection();
	
	@Override
	public List<UserShow> getShowByUserId(int userId) {
		List<UserShow> userShow = new ArrayList<UserShow>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("select user_id, ts.title, last_watched, ts.episodes from user_show us join tv_show ts on ts.show_id = us.show_id where user_id = ?");
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("user_id");
				int episodes = rs.getInt("episodes");
				String title = rs.getString("title");
				int lastWatched = rs.getInt("last_watched");

				userShow.add(new UserShow(id, title, episodes, lastWatched));
			}

			rs.close();
			//return userShow;

		} catch (SQLException e) {
		
			System.out.println("UserShow with userid = " + userId + " not found.");
			System.out.println(e);
		}
	return userShow;
	}

	@Override
	public int updateShowbyShowId(int showId, int userId, int userInput) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update user_show set last_watched = ? where user_id = ? and show_id = ?");
			pstmt.setInt(1, userInput);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, showId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
