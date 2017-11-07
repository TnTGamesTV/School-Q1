/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 07-11-2017
 */
public class List<T extends Object> {
	
	private Node<T> first;
	private Node<T> last;
	
	private int size;
	
	public List() {
		size = 0;
	}
	
	public void add(T object) {
		Node<T> node = new Node<T>(object);
		
		last.setNext(node);
	}
	
	public void set(int i, T object) {
		Node<T> currenNode = first;
		
		for(int c = 0; c < i; c++) {
			if(currenNode != null) {
				currenNode.setObject(object);
			}else {
				throw new RuntimeException("Index does not exist");
			}
			
			//Get next
			currenNode = currenNode.getNext();
		}
	}
	
	@SuppressWarnings("hiding")
	public <T extends Object> T get(int i) {
		Node<T> currenNode = first;
		
		for(int c = 0; c < i; c++) {
			if(currenNode != null) {
				return currenNode.getObject();
			}else {
				throw new RuntimeException("Index does not exist");
			}
			
			//Get next
			currenNode = currenNode.getNext();
		}
	}
}
