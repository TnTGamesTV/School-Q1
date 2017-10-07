/**
 * 
 */
package com.github.tntgamestv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TnTGamesTV Project: Sortieren und Sortieren Date: 05-10-2017
 */
public class SuperDuperSearchCommented {

	/* Main application void */
	public static void main(String[] args) {
		// Creating input
		List<Integer> input = Arrays.asList(8, 18, 88, 5, 42, 69, 240, 25);

		// Creating output and adding empty values
		List<Integer> output = new ArrayList<>();
		input.forEach(v -> output.add(null));

		// Sorting
		sort(input, 0, output);

		// Printing everything to console
		output.stream().forEachOrdered(System.out::println);
	}

	/**
	 * Sorting a given (sub)list
	 * 
	 * @param input
	 *            the (sub)list
	 * @param distance
	 *            the distance of the first object in input to the first object
	 *            in the global output list
	 * @param output
	 *            the global output list
	 */
	public static void sort(List<Integer> input, int distance, List<Integer> output) {
		// If there are more then one value (equals to "there is something to
		// sort")
		if (input.size() > 1) {
			// Select last element
			int pick = input.get(input.size() - 1);

			// Get new list (left for numbers that are smaller then 'pick')
			List<Integer> left = input.stream().filter(v -> v < pick).collect(Collectors.toList());
			// Get new list (right for numbers that are greater then 'pick')
			List<Integer> right = input.stream().filter(v -> v > pick).collect(Collectors.toList());

			// Setting pick to the correct position
			output.set(left.size() + distance, pick);

			// Sorting the left part (with the same distance)
			sort(left, distance, output);
			// Sorting the right part (with the size of left and one for 'pick'
			// plus distance)
			sort(right, left.size() + 1 + distance, output);
		} else if (input.size() == 1) {
			// If only one value left, write position to global output list
			output.set(distance, input.get(0));
		}
	}
}
