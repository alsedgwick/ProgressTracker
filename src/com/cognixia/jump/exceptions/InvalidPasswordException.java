package com.cognixia.jump.exceptions;

public class InvalidPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7356054266841869769L;

	public InvalidPasswordException()
	{
		super("That password is not valid. Try again.");
	}
}
