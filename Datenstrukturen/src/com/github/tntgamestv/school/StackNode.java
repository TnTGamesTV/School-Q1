/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 30-11-2017
 */
public class StackNode<T> {

	protected StackNode<T>	previous;
	private T				content;

	public StackNode(T content) {
		this.previous = null;
		this.content = content;
	}

	/**
	 * @return the next
	 */
	public StackNode<T> getPrevious() {
		return previous;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setPrevious(StackNode<T> previous) {
		this.previous = previous;
	}

	/**
	 * @return the content
	 */
	public T getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(T content) {
		this.content = content;
	}
}
