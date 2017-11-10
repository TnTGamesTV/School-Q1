/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: Datenstrukturen Date: 10-11-2017
 */
public class MapNode<K, V> {

	private K				key;
	private V				value;
	private MapNode<K, V>	next;

	public MapNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public MapNode<K, V> getNext() {
		return next;
	}

	public void setNext(MapNode<K, V> next) {
		this.next = next;
	}
}