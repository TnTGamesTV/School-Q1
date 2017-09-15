/**
 * 
 */
package com.github.tntgamestv.starbuzz;

/**
 * @author TnTGamesTV Project: Starbuzz Date: 08-09-2017
 */
public class SecondaryOrder {

	private double	price;
	private String	name;

	public SecondaryOrder(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
