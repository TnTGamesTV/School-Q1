/**
 * 
 */
package com.github.tntgamestv.starbuzz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TnTGamesTV
 * Project: Starbuzz
 * Date: 08-09-2017
 */
public class MainOrder {

	private PrimaryOrder primaryOrder;
	
	private List<SecondaryOrder> secondarOrders;
	
	public MainOrder() {
		this.secondarOrders = new ArrayList<>();
	}

	public void setPrimaryOrder(PrimaryOrder primaryOrder) {
		this.primaryOrder = primaryOrder;
	}
	
	public void addSecondaryOrder(SecondaryOrder secondaryOrder) {
		this.secondarOrders.add(secondaryOrder);
	}
	
	public String getTotal() {
		double total = 0;
		
		total += this.primaryOrder.getPrice();
		
		for(SecondaryOrder secondaryOrder : this.secondarOrders) {
			total += secondaryOrder.getPrice();
		}
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(total);
	}
}
