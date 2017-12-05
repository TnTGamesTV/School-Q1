/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 30-11-2017
 */
public class Stack<T> {

	private StackNode<T> top;
	private int size;
	
	public Stack() {
		this.size = 0;
		this.top = null;
	}
	
	public T pop() {
		if(top != null) {
			T content = top.getContent();
			top = top.getPrevious();
			size--;
			
			return content;
		}else {
			return null;
		}
	}
	
	public T top() {
		return top.getContent();
	}
	
	public void push(T content) {
		StackNode<T> newNode = new StackNode<T>(content);
		newNode.setPrevious(top);
		top = newNode;
		
		size++;
	}
	
	public void forEach(LambdaIterable<T> iterable) {
		StackNode<T> current = top;
		
		while(current != null && current.getPrevious() != null) {
			iterable.iterate(current.getContent());
			current = current.getPrevious();
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
