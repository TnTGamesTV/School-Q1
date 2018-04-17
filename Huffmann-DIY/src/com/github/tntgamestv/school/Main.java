/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.HashMap;
import java.util.List;

/**
 * @author TnTGamesTV Project: Huffmann-DIY Date: 10-04-2018
 */
public class Main {

	public static void main(String[] args) {
		String input = "Bananenmus";

		HuffmannTree tree = new HuffmannTree(input);

		if (tree.start()) {
			tree.display();
			
			HashMap<Character, List<Signal>> mapping = tree.returnResultMappedToChars();
			mapping.entrySet().stream().forEachOrdered((entry) ->
			{
				System.out.print(entry.getKey().toString() + ":");

				entry.getValue().forEach((item) ->
				{
					System.out.print(item.getSymbol() + " ");
				});

				System.out.println();
			});
		} else {
			System.exit(1);
		}
	}
}
