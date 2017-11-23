package com.github.tntgamestv.voc;

import com.github.tntgamestv.voc.Vokabel.Language;

/**
 * @author Finn Tegeler
 */
public class Main {

	public static void main(String[] args) {
		Vokabel v1a = new Vokabel("apple", "Apple", Language.ENGLISH);
		Vokabel v1b = new Vokabel("apple", "Apfel", Language.GERMAN);

		v1a.link(v1b);

		Vokabel v2a = new Vokabel("bread", "Bread", Language.ENGLISH);
		Vokabel v2b = new Vokabel("bread", "Brot", Language.GERMAN);

		v2a.link(v2b);

		VokabelListe list = new VokabelListe();
		list.append(v1a);
		list.append(v1b);
		list.append(v2a);
		list.append(v2b);

		list.startTraining(System.in, 4);
	}
}
