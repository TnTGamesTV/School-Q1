/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 07-11-2017
 * @param <T>
 */
public class List<T> {

	protected Node<T>	first;
	protected Node<T>	last;

	protected int		size;

	public List() {
		size = 0;
	}

	protected Node<T> getFirst() {
		return first;
	}

	public void add(T object) {
		Node<T> node = new Node<T>(object);

		if (last == null) {
			first = node;
			last = node;
		} else {
			last.setNext(node);
			last = node;
		}
		size++;

		//System.out.println("Add action @" + (size - 1) + " - Node: " + object.toString());
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

	/**
	 * Returns the object at
	 * 
	 * @param i
	 * @return
	 */
	public T get(int i) {
		Node<T> currenNode = first;

		if (i >= 0 && i < size) {
			int c = 0;
			while (c < i) {
				// Get next
				currenNode = currenNode.getNext();
				c++;
			}

			if (currenNode != null) {
				return currenNode.getObject();
			} else {
				System.out.println("Found no object for index: " + i + ", size: " + size);
				return null;
			}
		} else {
			throw new IllegalArgumentException("Index must be greater then or equal to zero and smaller then size");
		}
	}

	protected Node<T> getNode(int i) {
		Node<T> currentNode = first;

		if (i >= 0 && i < size) {
			for (int c = 0; c < i; c++) {
				currentNode = currentNode.getNext();
			}

			return currentNode;
		} else {
			throw new IllegalArgumentException("Index must be greater then or equal to ");
		}
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
			return i;
		}
		return -1;
	}

	public void forEach(LambdaIterable<T> iterable) {
		for (int i = 0; i < size; i++) {
			T object = this.get(i);

			iterable.iterate(object);
		}
	}

	public int size() {
		return size;
	}
	
	public void debug() {
		Node<T> currentNode = first;
		while(currentNode != null) {
			Log.d("Node: " + currentNode.getObject().toString());
			currentNode = currentNode.getNext();
		}
	}
}
