/**
 * 
 */
package com.github.tntgamestv.starbuzz;

/**
 * @author TnTGamesTV Project: Starbuzz Date: 21-09-2017
 */
public class Order {

	private double	price;
	private String	name;

	public Order(String name, double price) {
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
