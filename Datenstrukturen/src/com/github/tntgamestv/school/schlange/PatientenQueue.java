/**
 * 
 */
package com.github.tntgamestv.school.schlange;

import com.github.tntgamestv.school.Queue;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 14-12-2017
 */
public class PatientenQueue {

	private Queue<Patient> queue1;
	private Queue<Patient> queue2;
	private Queue<Patient> queue3;
	
	private int size;
	
	public PatientenQueue() {
		queue1 = new Queue<>();
		queue2 = new Queue<>();
		queue3 = new Queue<>();
		
		size = 0;
	}
	
	public void enqueue(Patient patient){
		//Insert new patient
		
		if(patient.getPriority() == 1) {
			queue1.enqueue(patient);
		}else if(patient.getPriority() == 2) {
			queue2.enqueue(patient);
		}else if(patient.getPriority() == 3) {
			queue3.enqueue(patient);
		}
	}
	
	/**
	 * Returns the next patient
	 * @return the next patient | null if size equals zero
	 */
	public Patient dequeue(){
		//Return next patient
		
		if(!queue3.isEmpty()) {
			Patient toReturn = queue3.front();
			queue3.dequeue();
			return toReturn;
		}else {
			if(!queue2.isEmpty()) {
				Patient toReturn = queue2.front();
				queue2.dequeue();
				return toReturn;
			}else {
				if(!queue1.isEmpty()) {
					Patient toReturn = queue1.front();
					queue1.dequeue();
					return toReturn;
				}
			}
		}
		
		return null;
	}
	
	public int size(){
		return size;
	}
}
