/**
 * 
 */
package com.github.tntgamestv.abrekursiv;

/**
 * @author TnTGamesTV Project: Sortieren und Sortieren Date: 13-10-2017
 */
public class Aufgabe1 {

	/*
	 * n! = 1 * 2 * 3 * ... * n
	 */

	public static void main(String[] args) {
		int result1 = calculateNotNIterativ(3);
		int result2 = calculateNotNRekursiv(3, 1);
		System.out.println("Result1: " + result1);
		System.out.println("Result2: " + result2);
	}

	public static int calculateNotNIterativ(int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= (i + 1);
		}
		
		return result;
	}

	public static int calculateNotNRekursiv(int n, int currentN) {
		if (currentN == n) {
			return n;
		} else {
			return currentN * calculateNotNRekursiv(n, currentN + 1);
		}
	}
}
