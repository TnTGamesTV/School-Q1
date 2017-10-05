/**
 * 
 */
package com.github.tntgamestv;

import java.util.Random;
import java.util.function.IntSupplier;

/**
 * @author TnTGamesTV Project: Sortieren und Sortieren Date: 26-09-2017
 */
public class RandomIntSupplier implements IntSupplier {

	/**
	 * The start and end of the supplied numbers
	 */
	private int		start;
	private int		end;

	/*
	 * All numbers from this RandomIntSupplier are coming from this randomizer
	 */
	private Random	randomizer;

	/**
	 * An endless stream of numbers that are randomly generated
	 * 
	 * @param start
	 *            the minimum value
	 * @param end
	 *            the maximum value
	 */
	public RandomIntSupplier(int start, int end) {
		this(start, end, System.currentTimeMillis());
	}

	/**
	 * An endless stream of numbers that are randomly generated
	 * 
	 * @param start
	 *            the minimum value
	 * @param end
	 *            the maximum value
	 * @param seed
	 *            the seed for the randomizer
	 */
	public RandomIntSupplier(int start, int end, long seed) {
		this.start = start;
		this.end = end;
		this.randomizer = new Random(seed);
	}

	/**
	 * Returns the next number
	 * 
	 * @see java.util.function.IntSupplier#getAsInt()
	 * @return the next int between start and end
	 */
	@Override
	public int getAsInt() {
		return (int) (Math.random() * end) + 1;
	}

}
