package com.github.tntgamestv.school.ski;

import com.github.tntgamestv.school.InsertList;
import com.github.tntgamestv.school.Node;

/**
 * @author Finn Tegeler
 */
public class SkiList extends InsertList<SkiInfo> {

	@Override
	public void add(SkiInfo info) {
		if (this.first != null && size >= 1) {
			Node<SkiInfo> currentNode = this.first;

			while (currentNode != null && currentNode.getObject().getTime() < info.getTime()) {
				currentNode = currentNode.getNext();
				// Skips nodes while time is smaller then time to insert
			}

			int i = 0;
			if (currentNode != null) {
				i = this.indexOf(currentNode.getObject());
				// Index of wrong
			} else {
				i = this.size;
			}

			this.insert(i, info);
		} else {
			super.add(info);
		}
	}
}
