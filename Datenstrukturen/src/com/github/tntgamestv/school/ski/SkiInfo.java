package com.github.tntgamestv.school.ski;

/**
 * @author Finn Tegeler
 */
public class SkiInfo {

	private String	name;
	private long	time;

	public SkiInfo(String name, long time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public String toString() {
		return name + ": " + time;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
}
