package com.cognixia.jump.DAO;

import java.util.List;

public interface UserShowDAO {
	public List<UserShow> getShowByUserId(int userId);
}
