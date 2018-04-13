/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author TnTGamesTV
 * Project: Huffmann-DIY
 * Date: 10-04-2018
 */
public class Main {

	public static void main(String[] args) {
		String input = "Regenwetter";
		
		input = input.toUpperCase();
		
		List<BinaryTree<Data>> nodes = new ArrayList<>();
		HashMap<String,Integer> amount = new HashMap<>();
		
		input.chars().forEachOrdered((c) -> {
			if(amount.containsKey("" + c)) {
				amount.put(""+ c, amount.get("" + c) + 1);
			}
		});
		
		amount.entrySet().stream().forEachOrdered((entry) -> {
			Data data = new Data(entry.getValue(), entry.getKey());
			
			nodes.add(new BinaryTree<Data>(data));
		});
		
		nodes.sort(new Comparator<BinaryTree<Data>>() {

			@Override
			public int compare(BinaryTree<Data> b1, BinaryTree<Data> b2) {
				return Integer.compare(b1.getContent().getAmount(), b2.getContent().getAmount());
			}});
		
		nodes.stream().min(new Comparator<BinaryTree<Data>>() {

			@Override
			public int compare(BinaryTree<Data> o1, BinaryTree<Data> o2) {
				return Integer.compare(o1.getContent().getAmount(), o2.getContent().getAmount());
			}});
	}
}
