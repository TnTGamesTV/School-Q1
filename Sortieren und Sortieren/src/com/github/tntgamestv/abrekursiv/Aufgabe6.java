/**
 * 
 */
package com.github.tntgamestv.abrekursiv;

/**
 * @author TnTGamesTV
 * Project: Sortieren und Sortieren
 * Date: 13-10-2017
 */
public class Aufgabe6 {
	
	public static void main(String[] args) {
		String input = "Peter";

		int result1 = invalidSearch(input);
		int result2 = getLength(input);

		System.out.println("Result of invalidSearch: " + result1);
		System.out.println("Result of getLength: " + result2);
	}
	
	public static int invalidSearch(String input) {
		return (int) input.chars().count();
	}
	
	public static int getLength(String input) {
		if(input.equalsIgnoreCase("")) {
			return 0;
		}else {
			return getLength(input.substring(1)) + 1;
		}
	}
}
