package com.github.tntgamestv;

import java.util.List;

/**
 * @author Finn Tegeler
 */
public class Util {

	static void print(String out) {
		System.out.println(out);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void print(List<Integer> supply) {
		supply.stream().forEach((v) ->
		{
			System.out.print(v + " ");
		});
		System.out.print("\r");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
