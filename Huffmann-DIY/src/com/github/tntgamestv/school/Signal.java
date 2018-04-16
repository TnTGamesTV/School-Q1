package com.github.tntgamestv.school;

/**
 * @author Finn Tegeler
 */
public enum Signal {

	LONG("-"), SHORT(".");

	private String symbol;

	Signal(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}
