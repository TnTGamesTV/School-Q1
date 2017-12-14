/**
 * 
 */
package com.github.tntgamestv.school.schlange;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 14-12-2017
 */
public class Patient {

	private String name;
	private int priority;
	
	public Patient(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
}
