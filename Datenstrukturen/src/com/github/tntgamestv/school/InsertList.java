package com.github.tntgamestv.school;

/**
 * @author Finn Tegeler
 */
public class InsertList<T> extends List<T> implements Insertable<T> {

	@Override
	public void insert(int i, T object) {
		if (size == 0 || size == i) {
			super.add(object);
			return;
		}

		if (i > 0 && i < this.size()) {
			Node<T> posNode = this.getNode(i);
			Node<T> beforNode = getBefor(posNode);

			Node<T> newNode = new Node<T>(object);

			beforNode.next = newNode;
			newNode.next = posNode;
			size++;

			System.out.println("Insert action @" + i + ", posNode: " + posNode.getObject().toString() + ", beforNode: "
					+ beforNode.getObject().toString());
		} else {
			throw new IndexOutOfBoundsException("Index must be smaller then size: " + i);
		}
	}

	private Node<T> getBefor(Node<T> next) {
		Node<T> currentNode = this.getFirst();
		@SuppressWarnings("unused")
		int i = 0;
		while (currentNode != null && currentNode != next && !currentNode.isLast()) {
			if (currentNode.next == next) {
				// System.out.println("GetBefor iteration. I: " + i);
				return currentNode;
			} else {
				currentNode = currentNode.next;
				i++;
			}
		}

		return null;
	}
}
