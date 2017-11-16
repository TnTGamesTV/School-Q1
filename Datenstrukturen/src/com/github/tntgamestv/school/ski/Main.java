package com.github.tntgamestv.school.ski;

/**
 * @author Finn Tegeler
 */
public class Main {

	public static void main(String[] args) {
		SkiList list = new SkiList();

		SkiInfo info1 = new SkiInfo("Max Mustermann", 100);
		SkiInfo info2 = new SkiInfo("Erika Mustermann", 200);
		SkiInfo info3 = new SkiInfo("Peter Mustermann", 250);
		SkiInfo info4 = new SkiInfo("Hans Mustermann", 150);

		list.add(info1); // Add @0
		list.add(info2); // Add @1
		list.add(info3); // Add @2
		list.add(info4); // Insert @1

		/**
		 * info1 -> 0; info2 -> 2; info3 -> 3; info4 -> 1;
		 */

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("" + list.get(3).getName());
	}
}
