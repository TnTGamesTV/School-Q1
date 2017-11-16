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
			Node<T> beforNode = this.getPrevious(posNode);

			Node<T> newNode = new Node<T>(object);

			beforNode.next = newNode;
			newNode.next = posNode;
			size++;

			/*System.out.println("Insert action @" + i + ", posNode: " + posNode.getObject().toString() + ", beforNode: "
					+ beforNode.getObject().toString());*/
		} else {
			throw new IndexOutOfBoundsException("Index must be smaller then size: " + i);
		}
	}
}
