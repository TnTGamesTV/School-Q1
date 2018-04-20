/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Huffmann-DIY Date: 10-04-2018
 */
public class Main {

	public static void main(String[] args) {
		String input = "Regenwetter";

		HuffmannTree tree = new HuffmannTree(input);

		tree.start();
		
		tree.display();

		tree.returnMapping().forEachOrdered((c,s) -> {
			System.out.println(c + ": " + s.toString());
		});
	}
}
