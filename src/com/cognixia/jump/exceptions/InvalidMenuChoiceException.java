package com.cognixia.jump.exceptions;

public class InvalidMenuChoiceException extends Exception
{
	private static final long serialVersionUID = 4189214782598705060L;
	
	public InvalidMenuChoiceException()
	{
		super("That menu choice is not valid. Try again.");
	}
}