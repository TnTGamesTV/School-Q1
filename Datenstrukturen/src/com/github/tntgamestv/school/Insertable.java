package com.github.tntgamestv.school;

/**
 * @author Finn Tegeler
 */
public interface Insertable<T> {

	public void insert(int i, T object);

	void insertNode(int i, Node<T> node);
}
