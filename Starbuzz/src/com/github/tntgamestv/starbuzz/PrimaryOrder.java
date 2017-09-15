/**
 * 
 */
package com.github.tntgamestv.starbuzz;

/**
 * @author TnTGamesTV Project: Starbuzz Date: 08-09-2017
 */
public class PrimaryOrder {

	private String	name;
	private double	price;

	public PrimaryOrder(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

}
