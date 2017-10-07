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
public class SuperDuperSearch {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(8, 18, 88, 5, 42, 69, 240, 25);
		List<Integer> output = new ArrayList<>();
		input.forEach(v -> output.add(null));

		sort(input, 0, output);

		output.stream().forEachOrdered(v -> System.out.println(v));
	}

	public static void sort(List<Integer> input, int distance, List<Integer> output) {
		if (input.size() > 1) {
			int pick = input.get(input.size() - 1);

			List<Integer> left = input.stream().filter(v -> v < pick).collect(Collectors.toList());
			List<Integer> right = input.stream().filter(v -> v > pick).collect(Collectors.toList());

			output.set(left.size() + distance, pick);

			sort(left, distance, output);
			sort(right, left.size() + distance + 1, output);
		} else if (input.size() == 1) {
			output.set(distance, input.get(0));
		}
	}
}
