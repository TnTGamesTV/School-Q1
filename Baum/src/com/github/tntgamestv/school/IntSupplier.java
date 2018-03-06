package com.github.tntgamestv.school;

import java.util.Random;

/**
 * @author Finn Tegeler
 */
public class IntSupplier {

	private int		start;
	private int		end;

	private Random	generator;

	/**
	 * Creates an int supplier which generates integers between start and end
	 * (both inclusive)
	 * 
	 * @param start
	 * @param end
	 */
	public IntSupplier(int start, int end) {
		this.start = start;
		this.end = end;

		this.generator = new Random();
	}

	public int get() {
		return this.generator.nextInt((end - start) + 1) + start;
	}
}
