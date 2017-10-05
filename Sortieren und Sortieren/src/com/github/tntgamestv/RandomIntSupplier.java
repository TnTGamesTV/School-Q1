/**
 * 
 */
package com.github.tntgamestv;

import java.util.function.IntSupplier;

/**
 * @author TnTGamesTV Project: Sortieren und Sortieren Date: 26-09-2017
 */
public class RandomIntSupplier implements IntSupplier {

	private int	start;
	private int	end;

	public RandomIntSupplier(int start, int end) {
		this.start = start;
		this.end = end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.function.IntSupplier#getAsInt()
	 */
	@Override
	public int getAsInt() {
		return (int) (Math.random() * end) + 1;
	}

}
