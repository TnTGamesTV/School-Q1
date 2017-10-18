package com.github.tntgamestv.selbstlernen_dienstag;

/**
 * @author Finn Tegeler
 */
public class TuermeVonHanoi {

	static void move(int index, int sourceStack, int workingStack, int destinationStack) {
		if (index > 1) move(index - 1, sourceStack, destinationStack, workingStack);
		if (index > 1) move(index - 1, workingStack, sourceStack, destinationStack);
	}
}
