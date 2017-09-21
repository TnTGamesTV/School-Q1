/**
 * 
 */
package com.github.tntgamestv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author TnTGamesTV
 * Project: Sortieren und Sortieren
 * Date: 21-09-2017
 */
public class SelectionSort {

	static int currentIndex = 0;
	static int currentCheckingIndex = 0;
	
	static int currentLowest = Integer.MAX_VALUE;
	static int currentIndexLowest = -1;
	
	public static void main(String[] args) {
		List<Integer> supply = new ArrayList<>();
		supply.add(1);
		supply.add(2);
		supply.add(4);
//		supply.add(5);
//		supply.add(8);
		Collections.shuffle(supply);
		
		System.out.println("Input:");
		supply.stream().forEach((v) -> {
			System.out.println("" + v);
		});
		
		currentIndex = 0;
		
		supply.stream().forEach((j) -> {
			currentCheckingIndex = 0;
			
			supply.stream().forEach((min) -> {
				if(min == j) return; //If own number -> skip
				
				if(min < currentLowest) {
					currentIndexLowest = currentCheckingIndex;
					currentLowest = min;
				}
				
				int currentIndexValue = supply.get(currentIndex);
				
				
				supply.set(currentIndex, currentLowest);
				supply.set(currentIndexLowest, currentIndexValue);
				
				currentCheckingIndex++;
			});
			
			currentIndex++; //Next number
		});

		System.out.println("Output:");
		supply.stream().forEach((v -> {
			System.out.println("" + v);
		}));
	}
}
