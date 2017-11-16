/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 07-11-2017
 */
public class Node<T> {

	protected Node<T>	next;
	private T			object;

	public Node(T pObject) {
		this.object = pObject;
	}

	public boolean isEmpty() {
		return object == null;
	}

	public boolean isLast() {
		return next == null;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @return the object
	 */
	public T getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(T object) {
		this.object = object;
	}
}
