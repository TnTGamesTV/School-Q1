/**
 * 
 */
package com.github.tntgamestv.school;

import javax.swing.JOptionPane;

/**
 * @author TnTGamesTV Project: Huffmann-DIY Date: 10-04-2018
 */
public class Main {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Insert text to encode");

		HuffmannTree tree = new HuffmannTree(input);
		
		tree.start();
		
		tree.display();

		tree.returnMapping().forEachOrdered((c,s) -> {
			System.out.println(c + ": " + s.toString());
		});
	}
}
