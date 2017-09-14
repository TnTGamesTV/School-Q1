package com.github.tntgamestv.school.exceptions;

/**
 * @author Finn Tegeler
 */
public class UserAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = -4941196320176639059L;

	public UserAlreadyRegisteredException(String error) {
		super(error);
	}
}
