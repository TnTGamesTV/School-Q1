/**
 * 
 */
package com.github.tntgamestv.abrekursiv;

/**
 * @author TnTGamesTV
 * Project: Sortieren und Sortieren
 * Date: 13-10-2017
 */
public class Aufgabe5 {

	public static void main(String[] args) {
		int result1 = diviIterativ(17, 3);
		int result2 = diviIterativ(17, 3);

		System.out.println("Result1: " + result1);
		System.out.println("Result2: " + result2);
	}
	
	public static int diviIterativ(int toDivi, int diviBy) {
		int result = 0;
		
		for(int i = 0; diviBy < toDivi; i++) {
			toDivi -= diviBy;
			
			result = i + 1;
		}
		return result;
	}
	
	public static int diviRekursiv(int toDivi, int diviBy) {
		if(toDivi <= diviBy) {
			return 0;
		}else {
			return diviRekursiv(toDivi - diviBy, diviBy) + 1;
		}
	}
}
