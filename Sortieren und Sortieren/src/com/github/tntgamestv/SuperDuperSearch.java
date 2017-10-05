/**
 * 
 */
package com.github.tntgamestv;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author TnTGamesTV Project: Sortieren und Sortieren Date: 05-10-2017
 */
public class SuperDuperSearch {

	public static final int NULL_VALUE = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] input = { 8, 18, 88, 5, 42, 240, 25 };
		int[] output = new int[input.length];

		int safety = 0;

		while (safety < 1000 && getNullValueAmount(input) != input.length) {
			safety++;

			input = sortArray(input, output);
		}

		IntStream stream = Arrays.stream(output);
		stream.forEach(value -> System.out.println(value));
	}

	public static long getNullValueAmount(int[] values) {
		IntStream stream = Arrays.stream(values);
		return stream.filter(value -> value == NULL_VALUE).count();

	}

	public static int[] sortArray(int[] input, int[] output) {
		if (input.length > 0) {
			int pick = input[input.length - 1];

			int[] left = new int[input.length];
			int[] right = new int[input.length];

			int indexLeft = 0;
			int indexRight = 0;

			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] < pick) {
					// Kleiner = <-
					left[indexLeft] = input[i];
					indexLeft++;
				} else {
					// Größer = ->
					right[indexRight] = input[i];
					indexRight++;
				}
			}
			output[indexLeft + 1] = pick;
			return formResult(left, right, NULL_VALUE);
		}
		return null;
	}

	/**
	 * Formats the result
	 * 
	 * @return as following: left + between + right
	 */
	public static int[] formResult(int[] left, int[] right, int... between) {
		int[] output = new int[left.length + between.length + right.length];

		System.arraycopy(left, 0, output, 0, left.length);
		System.arraycopy(between, 0, output, left.length, between.length);
		System.arraycopy(right, 0, output, between.length, right.length);

		return output;
	}
}
