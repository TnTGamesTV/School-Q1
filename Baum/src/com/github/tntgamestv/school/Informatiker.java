/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.Date;

/**
 * @author TnTGamesTV Project: Baum Date: 02-03-2018
 */
public class Informatiker implements Comparable<Informatiker> {

	private String	name;
	private int		day;
	private int		month;
	private int		year;

	public Informatiker(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public int compareTo(Informatiker arg0) {
		Date my = new Date(day, month, year);
		Date other = new Date(arg0.day, arg0.month, arg0.year);

		if (my.before(other)) return 1;
		if (my.equals(other)) return 0;
		if (my.after(other)) return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "[\"" + name + "\": " + day + "." + month + "." + year + "]";
	}
}
