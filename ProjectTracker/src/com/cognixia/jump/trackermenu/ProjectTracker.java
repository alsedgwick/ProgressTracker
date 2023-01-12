package com.cognixia.jump.trackermenu;

import java.util.List;

import com.cognixia.jump.DAO.User;
import com.cognixia.jump.DAO.UserDAOSQL;

public class ProjectTracker {

	public static void main(String[] args) {
		UserDAOSQL uds = new UserDAOSQL();
		User user = null;
		
		String username = "Micha";
		String password = "password123";
		String tvShow = "Good Omens";
		
		/*System.out.println("Welcome to the tracker! Please log in:");
		System.out.println("Username: " + user);*/
		
		try {
			user = uds.getUserByUS(username);
			//List<User> user = uds.getAllUsers();
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user.getPassword().equals(password)) {
			System.out.println("Log in successful!");
		}else {
			System.out.println("Password does not match.");
		}
		
		
		
		System.out.println("");
		//System.out.println("Password: " + password);
	}

}
