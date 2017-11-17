/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 16-11-2017
 */
public class SelectionSort<T extends Comparable<T>> implements Sortable<T> {

	@Override
	public void sort(List<T> rawList) {
		if (!(rawList instanceof InsertList)) {
			new RuntimeException("List must be of class InsertList");
		}

		InsertList<T> list = (InsertList<T>) rawList;

		if (list.size() > 1) {
			Node<T> current = list.getNode(1);

			while (current != null) {
				// While not reached list end
				int index = list.indexOf(current.getObject());
				list.remove(current);

				Node<T> backNode = current;
				while (list.getPrevious(backNode) != null && list.getPrevious(backNode).getObject().compareTo(current.getObject()) == 1) {
					backNode = list.getPrevious(backNode);
				}

				// Find node that is offset steps away and insert current befor
				int newIndex = index - list.indexOf(backNode.getObject());
				Log.d("Output: " + index + ", " + list.indexOf(backNode.getObject()));
				
				if (newIndex > 0) {
					list.insertNode(newIndex, current);
				}else {
					Log.d("newIndex is not greater then zero: " + newIndex);
				}

				// Next element
				current = current.next;
			}
		}
	}
}
