/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Baum Date: 02-03-2018
 */
public class InformatikerSupplier {

	private IntSupplier	day;
	private IntSupplier	month;
	private IntSupplier	year;
	private int			id;

	public InformatikerSupplier() {
		day = new IntSupplier(1, 28);
		month = new IntSupplier(1, 12);
		year = new IntSupplier(1970, 2000);
		id = 0;
	}

	public Informatiker get() {
		return new Informatiker("" + ++id, day.get(), month.get(), year.get());
	}
}
