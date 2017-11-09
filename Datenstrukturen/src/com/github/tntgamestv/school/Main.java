package com.github.tntgamestv.school;

/**
 * @author Finn Tegeler
 */
public class Main {

	public static void main(String[] args) {
		List<String> stringList = new List<String>();

		String string1 = "Grundstücksverkehrsgenehmigungszuständigkeitsübertragungsverordnung";
		String string2 = "Rindfleischetikettierungsüberwachungsaufgabenübertragungsgesetz";

		stringList.add(string1);
		stringList.add(string1);

		o("Size: " + stringList.size());

		stringList.add(string2);

		o("Size: " + stringList.size());
		o("Index: " + stringList.indexOf(string2));
	}

	private static void o(String out) {
		System.out.println(out);
	}
}
