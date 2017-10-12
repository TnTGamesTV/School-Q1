package com.github.tntgamestv;

import java.util.List;

/**
 * @author Finn Tegeler
 */
public class SelbstlernenRekursiv {

	public int binarySearchWrapper(List<Integer> input, int seachFor) {
		return binarySearch(input, seachFor, 0, input.size());
	}

	public int binarySearch(List<Integer> input, int searchFor, int min, int max) {
		int result = -1;
		int middle = Math.round((min + max) / 2);

		if (input.get(middle) == searchFor) {
			result = middle;
		} else if (searchFor < input.get(middle)) {
			result = binarySearch(input, searchFor, min, middle - 1);
		} else {
			result = binarySearch(input, searchFor, middle + 1, max);
		}

		return result;
	}
}
