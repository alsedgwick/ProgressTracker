package com.cognixia.jump.DAO;

import java.util.List;

public interface UserDAO {
	public User getUserByUS(String username);
	public List<User> getAllUsers();
}
