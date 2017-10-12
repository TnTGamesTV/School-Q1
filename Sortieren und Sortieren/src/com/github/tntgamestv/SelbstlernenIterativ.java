package com.github.tntgamestv;

import java.util.List;

/**
 * @author Finn Tegeler
 */
public class SelbstlernenIterativ {

	/**
	 * Searches for the given integer using iterative binary search
	 * 
	 * @param input
	 *            the list of integers (haystack)
	 * @param searchFor
	 *            the integer (needle)
	 * @return the position (index) of the given needle
	 */
	public int binarySearch(List<Integer> input, int searchFor) {
		int borderBottom = 1;
		int borderTop = input.size();
		int currentIndex = 0;
		boolean found = false;

		while (borderBottom <= borderTop) {
			currentIndex = (borderBottom + borderTop) / 2;

			if (input.get(currentIndex) == searchFor) {
				found = true;
				break;
			} else if (input.get(currentIndex) > searchFor) {
				borderTop = currentIndex - 1;
			} else {
				borderBottom = currentIndex + 1;
			}
		}
		return found ? currentIndex : -1;
	}
}
