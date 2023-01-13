package com.cognixia.jump.trackermenu;

import java.util.List;
import java.util.Scanner;
//import java.util.List;

import com.cognixia.jump.DAO.Show;
import com.cognixia.jump.DAO.ShowDAOSQL;
import com.cognixia.jump.DAO.User;
import com.cognixia.jump.DAO.UserDAOSQL;
import com.cognixia.jump.DAO.UserShow;
import com.cognixia.jump.DAO.UserShowDAO;
import com.cognixia.jump.DAO.UserShowDAOSQL;

public class ProjectTracker {
	
	private static boolean logIn = false;
	private static boolean terminate = true;
	private static User currentUser;
	
	public static void login(Scanner input) {
		UserDAOSQL uds = new UserDAOSQL();
		//User user = null;
		String username = "";
		String password = "";
		
		System.out.println("Welcome to the tracker! Please log in:");
		System.out.println("Username: ");
		username = input.nextLine();
		
		try {
			currentUser = uds.getUserByUS(username);
			//List<User> user = uds.getAllUsers();
			//System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Password: ");
		password = input.nextLine();
		
		if(currentUser.getPassword().equals(password)) {
			logIn = true;
			System.out.println("Log in successful!");
		}else {
			System.out.println("Password does not match.");
		}
	}
	
	public static void menu(Scanner input) {
		int choice = 0;
		System.out.println("Hello! What would you like to do? Type a number: ");
		System.out.println("1. View shows.");
		System.out.println("2. Edit shows.");
		System.out.println("3. Log out");
		choice = Integer.parseInt(input.nextLine());
		if(choice == 1) {
			view(currentUser);
		}else if(choice == 2) {
			edit();
		}else if(choice == 3) {
			logOut();
		}else {
			System.out.println("Not a valid choice.");
		}
	}
	
	public static void view(User user) {
		UserShowDAOSQL usd = new UserShowDAOSQL();
		System.out.println("Current Show List: ");
		System.out.println("------------------");
		//List<User> user = uds.getAllUsers();
		List<UserShow> shows = usd.getShowByUserId(user.getId());
		System.out.println(shows);
	}
	
	public static void edit() {
		System.out.println("Edit");	
	}
	
	public static void logOut() {
		System.out.println("Logged out, have a nice day!");
		System.exit(0);
		//Code to have program terminate here
	}

	public static void main(String[] args) {
		ShowDAOSQL sds = new ShowDAOSQL();
		Show show = sds.getShowByID(3);
		
		System.out.println(show);
		Scanner input = new Scanner(System.in);
		login(input);
		while(terminate) {
			if(logIn == true) {
				menu(input);
			}else {
				login(input);
			}
		}
		input.close();
	}

}
