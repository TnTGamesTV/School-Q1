/**
 * 
 */
package com.github.tntgamestv.school.schlange;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 14-12-2017
 */
public class Main {

	public static void main(String[] args) {
		Patient p1 = new Patient("Max Mustermann", 2);
		Patient p2 = new Patient("Erika Mustermann", 1);
		Patient p3 = new Patient("Bert Mustermann", 2);
		Patient p4 = new Patient("Alfred Mustermann", 3);
		Patient p5 = new Patient("Sabrine Mustermann", 3);
		
		PatientenQueue queue = new PatientenQueue();
		
		queue.enqueue(p1); //X
		queue.enqueue(p2);
		
		//Max Mustermann
		System.out.println("Removed: " + queue.dequeue().getName());
		
		queue.enqueue(p3);
		queue.enqueue(p4); //X
		
		//Alfred Mustermann
		System.out.println("Removed: " + queue.dequeue().getName());
		//Bert Mustermann
		System.out.println("Removed: " + queue.dequeue().getName());
		
		queue.enqueue(p5);
		//Sabrine Mustermann
		System.out.println("Removed: " + queue.dequeue().getName());
		//Erika Mustermann
		System.out.println("Removed: " + queue.dequeue().getName());
	}
}
