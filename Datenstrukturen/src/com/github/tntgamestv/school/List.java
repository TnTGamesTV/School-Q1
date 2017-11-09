/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 07-11-2017
 * @param <T>
 */
public class List<T> {

	private Node<T>	first;
	private Node<T>	last;

	private int		size;

	public List() {
		size = 0;
	}

	public void add(T object) {
		Node<T> node = new Node<T>(object);

		if (last == null) {
			first = node;
			last = node;
		} else {
			last.setNext(node);
		}
		size++;
	}

	public void set(int i, T object) {
		Node<T> currenNode = first;

		for (int c = 0; c < i; c++) {
			if (currenNode != null) {
				currenNode.setObject(object);
			} else {
				throw new RuntimeException("Index does not exist");
			}

			// Get next
			currenNode = currenNode.getNext();
		}
	}

	public T get(int i) {
		Node<T> currenNode = first;

		if (i > 0) {
			int c = 0;
			while (c < i) {
				// Get next
				currenNode = currenNode.getNext();
				c++;
			}

			if (currenNode != null) {
				return currenNode.getObject();
			}
		} else {
			throw new IllegalArgumentException("");
		}
		return null;
	}

	public int indexOf(T object) {
		Node<T> currentNode = first;
		int i = 0;
		while (currentNode != null && !currentNode.getObject().equals(object)) {
			// Get next
			currentNode = currentNode.getNext();
			i++;
		}

		if (currentNode != null) {
			return i + 1;
		}
		return -1;
	}

	public int size() {
		return size;
	}
}
