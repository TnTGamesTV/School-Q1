/**
 * 
 */
package com.github.tntgamestv.school;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author TnTGamesTV
 * Project: Baum
 * Date: 02-03-2018
 */
public class RandomInformatikerSupplier {

	private IntStream day;
	private IntStream month;
	private IntStream year;
	private int id;
	
	public RandomInformatikerSupplier() {
		day = IntStream.generate(()->{
			return (int)((Math.random()*30) + 1);
		});
		
		month = IntStream.generate(()->{
			return (int)((Math.random()*12) + 1);
		});
		
		year = IntStream.generate(()->{
			return (int)((Math.random()*50) + 1950);
		});
		
		id = 0;
	}
	
	public Informatiker get() {
		return null;
	}
	
}
