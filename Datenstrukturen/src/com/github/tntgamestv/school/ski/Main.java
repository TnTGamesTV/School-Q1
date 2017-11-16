package com.github.tntgamestv.school.ski;

import com.github.tntgamestv.school.Log;

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

		list.forEach((v) ->
		{
			Log.d(v.toString());
		});
	}
}
