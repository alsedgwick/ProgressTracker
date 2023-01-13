package com.cognixia.jump.DAO;

import java.util.List;

public interface UserShowDAO {
	public List<UserShow> getShowByUserId(int userId);
	public int updateShowbyShowId(int showId, int userId, int userInput);
}
