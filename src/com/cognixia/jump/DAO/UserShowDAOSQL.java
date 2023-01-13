package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognixia.jump.connection.BetterConnectionManager;

public class UserShowDAOSQL implements UserShowDAO {
	private Connection conn = BetterConnectionManager.getConnection();
	
	@Override
	public List<UserShow> getShowByUserId(int userId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("select user_id, title, last_watched, episodes from user_show us join tv_show ts on ts.show_id = us.show_id where user_id = ?");
			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();
			boolean r = pstmt.execute();
			//System.out.println(rs.getStatement());
			System.out.println(r);
		
			List<UserShow> userShow = null;
			
			System.out.println("Above printing out rs.next.");
			System.out.println(rs.next());
			System.out.println("Below printing out rs.next");

			while(rs.next()) {
				int id = rs.getInt("user_id");
				int sId = rs.getInt("show_id");
				int episodes = rs.getInt("episodes");
				String title = rs.getString("title");
				int lastWatched = rs.getInt("last_watched");
				//System.out.println("Hello from DAOSQL");
				//System.out.println(title);
				userShow.add(new UserShow(id, sId, title, episodes, lastWatched));
				/*for(int i = 0; i <10; i++) {
					System.out.println(userShow[i]);
				}*/
			}
			rs.close();
			return userShow;

		} catch (SQLException e) {
		
			System.out.println("UserShow with userid = " + userId + " not found.");
		}
	return null;
	}

}
