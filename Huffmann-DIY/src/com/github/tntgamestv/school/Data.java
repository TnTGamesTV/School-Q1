/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.Comparator;

/**
 * @author TnTGamesTV Project: Huffmann-DIY Date: 10-04-2018
 */
public class Data {

	public static class DataComperator implements Comparator<BinaryTree<Data>> {

		public int compare(BinaryTree<Data> o1, BinaryTree<Data> o2) {
			return Integer.compare(o1.getContent().getAmount(), o2.getContent().getAmount());
		}
	}

	private int		amount;
	private String	content;

	public Data(int amount, String content) {
		this.amount = amount;
		this.content = content;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
