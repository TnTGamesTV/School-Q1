package com.github.tntgamestv.school;

/**
 * @author Finn Tegeler
 */
public class ObjectAlreadyInsertedException extends RuntimeException {

	/**
	 * @param string
	 */
	public ObjectAlreadyInsertedException(String string) {
		super(string);
	}

	private static final long serialVersionUID = -3921740441877633942L;
}
