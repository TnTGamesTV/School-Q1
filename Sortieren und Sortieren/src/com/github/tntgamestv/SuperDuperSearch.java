/**
 * 
 */
package com.github.tntgamestv;

/**
 * @author TnTGamesTV Project: Sortieren und Sortieren Date: 05-10-2017
 */
public class SuperDuperSearch {

	public static void main(String[] args) {
		int[] input = { 8, 18, 88, 5, 42, 240, 25 };
		int[] support = new int[input.length];

		for (int i = 0; i < input.length; i++) {

		}
	}

	public int[] sortArray(int[] input, int[] output) {
		if (input.length > 0) {
			int pick = input[input.length - 1];

			int[] left = new int[input.length];
			int[] right = new int[input.length];
			
			int indexLeft = 0;
			int indexRight = 0;
			
			
			for (int i = 0; i < input.length - 1; i++) {
				if(input[i] < pick) {
					//Kleiner = <-
					left[indexLeft] = input[i];
					indexLeft++;
				}else {
					//Größer  = ->
					right[indexRight] = input[i];
					indexRight++;
				}
			}
		}
		//
		return null;
	}
}
