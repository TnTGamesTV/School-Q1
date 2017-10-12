package com.github.tntgamestv;

import java.util.Arrays;
import java.util.List;

/**
 * @author Finn Tegeler
 */
public class TestClazz {

	public static void main(String[] args) {
		SelbstlernenIterativ search1 = new SelbstlernenIterativ();
		SelbstlernenRekursiv search2 = new SelbstlernenRekursiv();

		List<Integer> input = Arrays.asList(1, 12, 145, 4535, 43);

		int result1 = search1.binarySearch(input, 145);
		int result2 = search2.binarySearchWrapper(input, 145);

		System.out.println("Result of search1: " + result1);
		System.out.println("Result of search2: " + result2);
	}
}
