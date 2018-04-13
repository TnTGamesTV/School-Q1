/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV
 * Project: Huffmann-DIY
 * Date: 10-04-2018
 */
public class Data {

	private int amount;
	private String content;
	
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
	 * @param amount the amount to set
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
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
