/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV
 * Project: Datenstrukturen
 * Date: 10-11-2017
 */
public class Map<K,V> {
	
	private MapNode<K, V> first;
	private MapNode<K, V> last;
	private int size;
	
	public Map() {
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unused")
	public V get(K key) {
		MapNode<K,V> currentNode = first;

		if (key != null) {
			int c = 0;
			while (!currentNode.getKey().equals(key)) {
				// Get next
				currentNode = currentNode.getNext();
			}

			if (currentNode != null) {
				return currentNode.getValue();
			}
		} else {
			throw new IllegalArgumentException("Key cannot be null");
		}
		return null;
	}
	
	public boolean contains(K key) {
		MapNode<K,V> currentNode = first;

		if (key != null) {
			while (currentNode != null && !currentNode.getKey().equals(key)) {
				// Get next
				currentNode = currentNode.getNext();
			}

			if(currentNode != null) {
				if(currentNode.getKey().equals(key)){
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		} else {
			throw new IllegalArgumentException("Key cannot be null");
		}
	}
	
	public void put(K key, V value) {
		if(contains(key)) {
			remove(key);
			
			MapNode<K, V> newNode = new MapNode<K, V>(key, value);
			last.setNext(newNode);
			last = newNode;
		}else{
			MapNode<K, V> newNode = new MapNode<K, V>(key, value);
			
			if(last != null) {
				last.setNext(newNode);
			}else {
				first = newNode;
			}
			
			last = newNode;
			
			size++;
		}
	}
	
	public void remove(K key) {
		MapNode<K,V> prevNode = null;
		MapNode<K,V> currentNode = first;

		if (key != null) {
			while (!currentNode.getKey().equals(key)) {
				// Get next
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}

			if (currentNode != null) {
				MapNode<K, V> nextNode = currentNode.getNext();
				
				prevNode.setNext(nextNode);
				
				size--;
			}
		} else {
			throw new IllegalArgumentException("Key cannot be null");
		}
	}
}
