package com.github.tntgamestv;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Finn Tegeler
 */
public class InPlace1 {

	public static void main(String[] args) {
		// int[] input = new int[] { 4, 1, 0, 2 };

		Integer[] input = new Integer[50000];
		for (int i = 0; i < input.length; i++) {
			input[i] = i;
		}
		Collections.shuffle(Arrays.asList(input));

		int temp;
		
		long start = System.nanoTime();
		
		for (int i = 1; i < input.length; i++) {
			// Alle zahlen außer die erste wegen [j - 1]
			// wenn i = 0 wäre würde [j - 1] ein Index von -1 sein
			for (int j = i; j > 0; j--) {
				// Für alle Zahlen vor der aktuell inspizierten Zahl
				if (input[j] < input[j - 1]) {
					// Wenn die aktuelle Zahl kleiner als die davor ist
					// Dies bewegt die Zahl nach links (also runter)
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;

					// Einmal tauschen
				}
			}
		}
		
		long end = System.nanoTime();
		
		// input[500] = 300;

		// Finale Überprüfung der Zahlen
		// Folgendes muss gegeben sein:
		// x => aktuelle Zahl die geprüft wird
		// x - 1 < x && x < x + 1 (außer wenn x == 0 oder x == input.length
		System.out.println("Output:");
		for (int x = 0; x < input.length; x++) {
			if (!(input[x] < input[x + 1])) {
				// Wenn dies nicht zutrifft
				// Ausgeben und abbrechen
				System.out.println("Wrong!");
				return;
			}

			if (x == (input.length - 2)) break;
		}
		// Wenn alles stimmt: ausgeben
		System.out.println("Correct!");
		System.out.println("Zeit: " + ((end - start) / 1000 / 1000 / 1000) + " Sekunden");
	}
}
