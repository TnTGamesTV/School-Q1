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
		
		Map<String, String> map = new Map<String,String>();
		map.put("string", string1);
		
		o("MapSize: " + map.size());
		o("Get: " + map.get("string"));
	}

	private static void o(String out) {
		System.out.println(out);
	}
}
