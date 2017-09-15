/**
 * 
 */
package com.github.tntgamestv.starbuzz;

import java.util.List;

/**
 * @author TnTGamesTV
 * Project: Starbuzz
 * Date: 08-09-2017
 */
public class Order {

	private PrimaryOrder primaryOrder;
	
	private List<SecondaryOrder> secondarOrders;
	
	public Order() {
		
	}

	public void setPrimaryOrder(PrimaryOrder primaryOrder) {
		this.primaryOrder = primaryOrder;
	}
	
	public void addSecondaryOrder(SecondaryOrder secondaryOrder) {
		this.secondarOrders.add(secondaryOrder);
	}
	
	public double getTotal() {
		double total = 0;
		
		total += this.primaryOrder.getPrice();
		
		for(SecondaryOrder secondaryOrder : this.secondarOrders) {
			total += secondaryOrder.getPrice();
		}
		
		return total;
	}
}
