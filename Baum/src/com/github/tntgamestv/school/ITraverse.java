
/**
 * 
 */
package com.github.tntgamestv.school;

/**
 * @author TnTGamesTV Project: B�ume Date: 22-02-2018
 */
public interface ITraverse<T extends Comparable<T>> {

	boolean traverse(BinarySearchTree<T> tree);
}