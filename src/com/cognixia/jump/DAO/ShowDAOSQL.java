package com.cognixia.jump.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.connection.BetterConnectionManager;

public class ShowDAOSQL implements ShowDAO{
	private Connection conn = BetterConnectionManager.getConnection();
	
	@Override
	public Show getShowByID(int id) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from tv_show where show_id = ?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			
			Show show = null;
			while(rs.next()) {
				int showId = rs.getInt("show_id");
				String title = rs.getString("title");
				int episodes = rs.getInt("episodes");
				show = new Show(showId, title, episodes);
			}
			rs.close();
			return show;

		} catch (SQLException e) {
			
			System.out.println("Show with id = " + id + " not found.");
		}

		return null;
	}
	
}
