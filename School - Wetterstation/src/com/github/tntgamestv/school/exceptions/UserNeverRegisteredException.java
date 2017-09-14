package com.github.tntgamestv.school.exceptions;

/**
 * @author Finn Tegeler
 */
public class UserNeverRegisteredException extends RuntimeException {

	private static final long serialVersionUID = -6985660761027580956L;

	public UserNeverRegisteredException(String error) {
		super(error);
	}
}
