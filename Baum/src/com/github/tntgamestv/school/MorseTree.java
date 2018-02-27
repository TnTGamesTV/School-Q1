/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TnTGamesTV Project: Bäume Date: 22-02-2018
 */
public class MorseTree extends BinaryTree<String> {

	public enum Type {
		SHORT("."), LONG("-");

		String symbol;

		Type(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}
	}

	public String findChar(List<Type> input) {
		BinaryTree<String> current = this;

		for (Type t : input) {
			System.out.println(t.symbol);
			current = t == Type.SHORT ? current.getLeftTree() : current.getRightTree();
		}

		return current.getContent();
	}

	public List<Type> findTypes(String s) {
		List<Type> result = new LinkedList<>();

		this.findTypes(this, result, new LinkedList<Type>(), s);

		return result;
	}

	private void findTypes(BinaryTree<String> tree, List<Type> result, List<Type> tmp, String s) {
		if (tree.getContent().equals(s)) {
			result.addAll(tmp);
			return;
		}

		if (tree.getLeftTree() != null && tree.getLeftTree().getContent() != null) {
			tmp.add(Type.SHORT);
			this.findTypes(tree.getLeftTree(), result, tmp, s);
		}

		if (tree.getRightTree() != null && tree.getRightTree().getContent() != null) {
			tmp.add(Type.LONG);
			this.findTypes(tree.getRightTree(), result, tmp, s);
		}

		tmp.remove(tmp.size() - 1);
	}
}