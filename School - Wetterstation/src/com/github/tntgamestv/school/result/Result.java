package com.github.tntgamestv.school.result;

/**
 * @author Finn Tegeler
 */
public class Result {

	public enum Type {
		PRESSURE, HUMIDITY, TEMPERATURE;
	}

	private double	value;
	private Type	type;

	public Result(double value, Type type) {
		this.value = value;
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
}
