/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 16-11-2017
 */
public class SelectionSort<T extends Comparable<T>> implements Sortable<T> {
	
	@Override
	public void sort(List<T> list) {
		if(list.size() > 1) {
			Node<T> first = list.first;
			Node<T> last = list.last;
			Node<T> current = list.getNode(1);
			
			while(current != null) {
				//While not reached list end
				Node<T> tmp = current;
				list.remove(tmp);
				
				while(list.getPrevious(tmp).getObject().compareTo(tmp.getObject()) == 1){
					//Change
				}
				
				//Next element
				current = current.next;
			}
		}
	}
}
