/**
 * 
 */
package com.github.tntgamestv.voc;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 21-11-2017
 */
public class VokabelListe extends List<Vokabel> {

	/* Stats */
	private int		correct	= 0;
	private int		wrong	= 0;
	private int		index	= 0;
	private int		max		= 0;

	private Vokabel	current;
	private Scanner	inputHandler;

	public void startTraining(InputStream console, int number) {
		System.out.println("Starting training with " + number + " questions");

		inputHandler = new Scanner(console);
		this.max = number;

		// Because of bad impl of List: next line needed
		this.toFirst();
		current = super.current.getContentObject();

		System.out.println("Die erste Vokabel ist: " + current.getPartner().getContent());

		while (index < max || inputHandler.hasNext()) {
			String result = inputHandler.next();

			String output = this.input(result);
			System.out.println("Ergebnis: " + output);

			if (!output.contains("Ende der Abfrage")) {
				System.out.println("Die nächste Vokabel ist: " + current.getPartner().getContent());
			} else {
				break;
			}
		}

		abortTraining(0);
	}

	public void abortTraining(int exitCode) {
		inputHandler.close();
		System.out.println(this.getResult()); // Print unfinished (or finished)
												// result

		System.out.println("Training was aborted (Code: " + exitCode + ")");
	}

	public String getResult() {
		return "Result: " + correct + " Vokabeln richtig und " + wrong + " falsch.";
	}

	public String input(String input) {
		String output = "";
		if (current.getContent().equalsIgnoreCase(input)) {
			correct++;

			output = "Richtig. Nächste Vokabel!";
		} else {
			wrong++;

			output = "Leider falsch. Die richtige Antwort wäre " + current.getContent() + " gewesen.";
		}

		// Next vokabel
		super.next();

		if (index == max || super.current == null) {
			// Abort
			return output + "\nDies ist das Ende der Abfrage!";
		} else {
			this.current = super.current.getContentObject();
			this.index++;
		}

		return output;
	}
}
