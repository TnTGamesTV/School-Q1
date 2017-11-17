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

		}

		InsertList<T> list = (InsertList<T>) rawList;

		if (list.size() > 1) {
			Node<T> current = list.getNode(1);

			while (current != null) {
				// While not reached list end
				list.remove(current);

				int offset = 0;

				while (list.getPrevious(current).getObject().compareTo(current.getObject()) == 1) {
					offset++;
				}

				// Find node that is offset steps away and insert current befor
				int index = list.indexOf(current.getObject());
				int newIndex = index - offset;

				if (newIndex > 0) {
					list.insert(newIndex, current);
				}

				// Next element
				current = current.next;
			}
		}
	}
}
