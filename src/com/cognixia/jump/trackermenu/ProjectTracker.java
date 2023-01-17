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
import com.cognixia.jump.exceptions.InvalidMenuChoiceException;
import com.cognixia.jump.exceptions.InvalidPasswordException;

public class ProjectTracker {
	
	private static boolean logIn = false;
	// private static boolean terminate = true;
	private static User currentUser;
	private static UserShowDAOSQL usd = new UserShowDAOSQL();
	
	public static void login(Scanner input) throws InvalidPasswordException {
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
			System.out.print("Hello! ");
		}else if(!currentUser.getPassword().equals(password)) {
			throw new InvalidPasswordException();
		}
	}
	
	public static void menu(Scanner input) throws InvalidMenuChoiceException {
		List<UserShow> shows = usd.getShowByUserId(currentUser.getId());
		
		int choice = 0;
		view(currentUser);
		System.out.println("To edit a show type its number: ");
		System.out.println("Type 0 to log out");
		choice = Integer.parseInt(input.nextLine());
		if(choice == 0) {
			logOut();
		}else if(choice >= 1 && choice <= shows.size()) {
				System.out.println(shows.get(choice - 1).getTitle() + " was selected.");
				edit(choice, input);
		}else if(choice < 1 || choice > shows.size()) {
			throw new InvalidMenuChoiceException();
		}

	}
	
	public static void view(User user) {
		List<UserShow> shows = usd.getShowByUserId(currentUser.getId());
		
		System.out.println("Current Show List: ");
		System.out.println("------------------");

		for(int i = 0; i < shows.size(); i++) {
			System.out.println("Show " + (i + 1) +": " + shows.get(i).getTitle());
			System.out.println("Status: " + shows.get(i).getLastWatched() + "/" + shows.get(i).getEpisodes() );
			System.out.print("Percentage watched: ");
			System.out.printf("%.2f", (((float)(shows.get(i).getLastWatched())  / (float)shows.get(i).getEpisodes()) * 100));
			System.out.print("%");
			System.out.println("\n");
		}
	}
	
	public static void edit(int choice, Scanner input) {
		List<UserShow> shows = usd.getShowByUserId(currentUser.getId());
		
		System.out.println("Enter your last watched episode: ");
		int lastEpisodeWatched = Integer.parseInt(input.nextLine());
		
		usd.updateShowbyShowId(lastEpisodeWatched, currentUser.getId(), choice);

		view(currentUser);
	}
	
	public static void logOut() {
		System.out.println("Logged out, have a nice day!");
		logIn = false;
		System.exit(0);
	}

	public static void main(String[] args) {
		ShowDAOSQL sds = new ShowDAOSQL();
		Scanner input = new Scanner(System.in);
		while(logIn == false) {
			try {
				login(input);
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		while(logIn == true) {
			try {
				menu(input);
			} catch (InvalidMenuChoiceException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		input.close();
	}

}
