package com.cognixia.jump.trackermenu;

import java.util.Scanner;
//import java.util.List;

import com.cognixia.jump.DAO.Show;
import com.cognixia.jump.DAO.ShowDAOSQL;
import com.cognixia.jump.DAO.User;
import com.cognixia.jump.DAO.UserDAOSQL;

public class ProjectTracker {
	
	private static boolean logIn = false;
	
	public static void login(Scanner input) {
		UserDAOSQL uds = new UserDAOSQL();
		User user = null;
		//Scanner input = new Scanner(System.in);
		String username = "";
		String password = "";
		//String tvShow = "Good Omens";
		
		System.out.println("Welcome to the tracker! Please log in:");
		System.out.println("Username: ");
		username = input.nextLine();
		
		try {
			user = uds.getUserByUS(username);
			//List<User> user = uds.getAllUsers();
			//System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Password: ");
		password = input.nextLine();
		
		if(user.getPassword().equals(password)) {
			System.out.println("Log in successful!");
			logIn = true;
		}else {
			System.out.println("Password does not match.");
		}
	}
	
	public static void menu(Scanner input) {
		int choice = 0;
		System.out.println("Hello! What would you like to do? Type a number: ");
		System.out.println("1. View shows.");
		System.out.println("2. Edit shows.");
		choice = Integer.parseInt(input.nextLine());
		if(choice == 1) {
			view();
		}else if(choice == 2) {
			edit();
		}else {
			System.out.println("Not a valid choice.");
		}
	}
	
	public static void view() {
		System.out.println("Current Show List: ");
		System.out.println("__________________");
	}
	
	public static void edit() {
		System.out.println("Edit");	
	}

	public static void main(String[] args) {
		ShowDAOSQL sds = new ShowDAOSQL();
		Show show = sds.getShowByID(3);
		
		System.out.println(show);
		Scanner input = new Scanner(System.in);
		login(input);
		if(logIn == true) {
			menu(input);
		}else {
			login(input);
		}
		input.close();
	}

}
