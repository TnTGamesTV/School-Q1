package com.github.tntgamestv.school;

/**
 * Mithilfe der generischen Klasse BinaryTree koennen beliebig viele
 * Inhaltsobjekte vom Typ ContentType in einem Binaerbaum verwaltet werden. Ein
 * Objekt der Klasse stellt entweder einen leeren Baum dar oder verwaltet ein
 * Inhaltsobjekt sowie einen linken und einen rechten Teilbaum, die ebenfalls
 * Objekte der generischen Klasse BinaryTree sind.
 */
public class BinaryTree<T extends Comparable<T>> {

	/* --------- Anfang der privaten inneren Klasse -------------- */

	/**
	 * Durch diese innere Klasse kann man dafuer sorgen, dass ein leerer Baum
	 * null ist, ein nicht-leerer Baum jedoch immer eine nicht-null-Wurzel sowie
	 * nicht-null-Teilbaeume, ggf. leere Teilbaeume hat.
	 */
	private class BTNode<T extends Comparable<T>> {

		private T				content;
		private BinaryTree<T>	left, right;

		public BTNode(T pContent) {
			// Der Knoten hat einen linken und einen rechten Teilbaum, die
			// beide von null verschieden sind. Also hat ein Blatt immer zwei
			// leere Teilbaeume unter sich.
			this.content = pContent;
			left = new BinaryTree<T>();
			right = new BinaryTree<T>();
		}

	}

	/* ----------- Ende der privaten inneren Klasse -------------- */

	private BinaryTree<T>.BTNode<T> node;

	/**
	 * Nach dem Aufruf des Konstruktors existiert ein leerer Binaerbaum.
	 */
	public BinaryTree() {
		this.node = null;
	}

	/**
	 * Wenn der Parameter pContent ungleich null ist, existiert nach dem Aufruf
	 * des Konstruktors der Binaerbaum und hat pContent als Inhaltsobjekt und
	 * zwei leere Teilbaeume. Falls der Parameter null ist, wird ein leerer
	 * Binaerbaum erzeugt.
	 * 
	 * @param pContent
	 *            das Inhaltsobjekt des Wurzelknotens vom Typ ContentType
	 */
	public BinaryTree(T pContent) {
		if (pContent != null) {
			this.node = new BTNode<T>(pContent);
		} else {
			this.node = null;
		}
	}

	/**
	 * Wenn der Parameter pContent ungleich null ist, wird ein Binaerbaum mit
	 * pContent als Inhalt und den beiden Teilbaeume pLeftTree und pRightTree
	 * erzeugt. Sind pLeftTree oder pRightTree gleich null, wird der
	 * entsprechende Teilbaum als leerer Binaerbaum eingefuegt. So kann es also
	 * nie passieren, dass linke oder rechte Teilbaeume null sind. Wenn der
	 * Parameter pContent gleich null ist, wird ein leerer Binaerbaum erzeugt.
	 * 
	 * @param pContent
	 *            das Inhaltsobjekt des Wurzelknotens vom Typ ContentType
	 * @param pLeftTree
	 *            der linke Teilbaum vom Typ BinaryTree<ContentType>
	 * @param pRightTree
	 *            der rechte Teilbaum vom Typ BinaryTree<ContentType>
	 */
	public BinaryTree(T pContent, BinaryTree<T> pLeftTree, BinaryTree<T> pRightTree) {
		if (pContent != null) {
			this.node = new BTNode<T>(pContent);
			if (pLeftTree != null) {
				this.node.left = pLeftTree;
			} else {
				this.node.left = new BinaryTree<T>();
			}
			if (pRightTree != null) {
				this.node.right = pRightTree;
			} else {
				this.node.right = new BinaryTree<T>();
			}
		} else {
			// Da der Inhalt null ist, wird ein leerer BinarySearchTree erzeugt.
			this.node = null;
		}
	}

	public boolean isEmpty() {
		return this.node == null;
	}

	public void insert(T content) {
		this.insert(this, content);
	}

	public void setContent(T pContent) {
		if (pContent != null) {
			if (this.isEmpty()) {
				node = new BTNode<T>(pContent);
				this.node.left = new BinaryTree<T>();
				this.node.right = new BinaryTree<T>();
			}
			this.node.content = pContent;
		}
	}

	public T getContent() {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.node.content;
		}
	}

	public void setLeftTree(BinaryTree<T> pTree) {
		if (!this.isEmpty() && pTree != null) {
			this.node.left = pTree;
		}
	}

	public void setRightTree(BinaryTree<T> pTree) {
		if (!this.isEmpty() && pTree != null) {
			this.node.right = pTree;
		}
	}

	public BinaryTree<T> getLeftTree() {
		if (!this.isEmpty()) {
			return this.node.left;
		} else {
			return null;
		}
	}

	public BinaryTree<T> getRightTree() {
		if (!this.isEmpty()) {
			return this.node.right;
		} else {
			return null;
		}
	}

	public void preorder(BinaryTree<T> b, ITraverse<T> iinterface) {
		if (!b.isEmpty()) {
			if (iinterface.traverse(b)) return;
			if (b.getLeftTree() != null) inorder(b.getLeftTree(), iinterface);
			if (b.getRightTree() != null) inorder(b.getRightTree(), iinterface);
		}
		return;
	}

	public void inorder(BinaryTree<T> b, ITraverse<T> iinterface) {
		if (!b.isEmpty()) {
			if (b.getLeftTree() != null) inorder(b.getLeftTree(), iinterface);
			if (iinterface.traverse(b)) return;
			if (b.getRightTree() != null) inorder(b.getRightTree(), iinterface);
		}
		return;
	}

	public void postorder(BinaryTree<T> b, ITraverse<T> iinterface) {
		if (!b.isEmpty()) {
			if (b.getLeftTree() != null) inorder(b.getLeftTree(), iinterface);
			if (b.getRightTree() != null) inorder(b.getRightTree(), iinterface);
			if (iinterface.traverse(b)) return;
		}
		return;
	}

	public void insert(BinaryTree<T> b, T input) {
		if (b.isEmpty()) {
			b.setContent(input);
		} else {
			if (input.compareTo(b.getContent()) > 0) {
				insert(b.getRightTree(), input);
			} else if (input.compareTo(b.getContent()) < 0) {
				insert(b.getLeftTree(), input);
			} else {
				throw new ObjectAlreadyInsertedException("This object has already been inserted!");
			}
		}
	}
}
