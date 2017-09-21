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
public class SelectionSort2 {

	public static void main(String[] args) {
		List<Integer> supply = new ArrayList<>();
		supply.add(1);
		supply.add(2);
		supply.add(3);
		supply.add(4);
		supply.add(5);
		Collections.shuffle(supply);
		
		System.out.println("Input:");
		supply.stream().forEachOrdered((v) -> {
			System.out.println("" + v);
		});
		
		for(int i = 0; i < supply.size(); i++) {
			int lowestIndex = 0;
			
			for(int j = i + 1; j < supply.size(); j++) {
				
				if(supply.get(j) < supply.get(lowestIndex)) {
					lowestIndex = j;
				}
			}
			
			int lowest = supply.get(lowestIndex);
			int current = supply.get(i);
			
			supply.set(lowestIndex, current);
			supply.set(i, lowest);
		}
		
		System.out.println("Output:");
		supply.stream().forEachOrdered((v) -> {
			System.out.println("" + v);
		});
	}
}
