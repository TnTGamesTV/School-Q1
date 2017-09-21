/**
 * 
 */
package com.github.tntgamestv.starbuzz;

import com.github.tntgamestv.starbuzz.primary.Hausmarke;
import com.github.tntgamestv.starbuzz.secondary.Zucker;

/**
 * @author TnTGamesTV
 * Project: Starbuzz
 * Date: 08-09-2017
 */
public class Main {

	public static void main(String[] args) {
		MainOrder main = new MainOrder();
		
		main.setPrimaryOrder(new Hausmarke());

		main.addSecondaryOrder(new Zucker());
		main.addSecondaryOrder(new Zucker());
		
		System.out.println(main.getTotal());
	}
}
