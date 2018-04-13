/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author TnTGamesTV Project: Huffmann-DIY Date: 13-04-2018
 */
public class Util {

	public static HashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> passedMap) {
		List<String> mapKeys = new ArrayList<>(passedMap.keySet());
		List<Integer> mapValues = new ArrayList<>(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		HashMap<String, Integer> sortedMap = new LinkedHashMap<>();

		Iterator<Integer> valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Integer val = valueIt.next();
			Iterator<String> keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				String key = keyIt.next();
				Integer comp1 = passedMap.get(key);
				Integer comp2 = val;

				if (comp1.equals(comp2)) {
					keyIt.remove();
					sortedMap.put(key, val);
					break;
				}
			}
		}
		return sortedMap;
	}
}
