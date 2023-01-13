package com.cognixia.jump.exceptions;

import java.util.Scanner;

public class Test
{

	public static void main(String[] args) 
	{
		try
		{
			int choice = getChoice();
			System.out.println("You picked " + choice + ", which is valid!");
		}
		catch (InvalidMenuChoiceException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static int getChoice() throws InvalidMenuChoiceException
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter a number between 1 and 9: ");
		int choice = s.nextInt();
		
		if (choice < 1 || choice > 9)
		{
			s.close();
			throw new InvalidMenuChoiceException();
		}
		s.close();
		return choice;
	}

}
