package com.github.tntgamestv.school;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 * @author Finn Tegeler
 */
public class GraphicalTreeWrapper<T extends Comparable<T>> {

	private Graph						graph;
	private BinarySearchTree<T>			tree;
	private BinarySearchTree<String>	idTree;

	public GraphicalTreeWrapper(BinarySearchTree<T> tree) {
		this.graph = new SingleGraph("Tree");
		this.tree = tree;
		this.idTree = new BinarySearchTree<>();

		this.idTree.setContent("");
		this.prepareIdTree(this.tree, idTree);
	}

	private void prepareIdTree(BinarySearchTree<T> tree, BinarySearchTree<String> idTree) {
		if (!tree.isEmpty()) {
			if (tree.getLeftTree() != null && tree.getLeftTree().getContent() != null) {
				idTree.setLeftTree(new BinarySearchTree<String>(""));
				prepareIdTree(tree.getLeftTree(), idTree.getLeftTree());
			}

			// Create new node
			idTree.setContent(new RandomString().nextString());

			if (tree.getRightTree() != null && tree.getRightTree().getContent() != null) {
				idTree.setRightTree(new BinarySearchTree<String>());
				prepareIdTree(tree.getRightTree(), idTree.getRightTree());
			}

		}
	}

	public void display() {
		graph.setStrict(true);
		
		graph.setAttribute("ui.stylesheet", "node {\r\n" + 
				"        fill-color: black;\r\n" + 
				"    }\r\n" + 
				"    node.marked {\r\n" + 
				"        fill-color: red;\r\n" + 
				"    }");
		
		graph.addNode(idTree.getContent());
		graph.getNode(idTree.getContent()).addAttribute("ui.class", "marked");
		
		iterate(tree, idTree);
		
		Viewer viewer = graph.display();
		
	}

	private void iterate(BinarySearchTree<T> tree, BinarySearchTree<String> idTree) {
		if (!tree.isEmpty()) {
			if (tree.getLeftTree() != null && tree.getLeftTree().getContent() != null) {
				graph.addNode(idTree.getLeftTree().getContent());
				graph.addEdge(new RandomString().nextString(), idTree.getContent(), idTree.getLeftTree().getContent());
				iterate(tree.getLeftTree(), idTree.getLeftTree());
			}

			// Create new node
			graph.getNode(idTree.getContent()).setAttribute("ui.label", tree.getContent().toString());

			if (tree.getRightTree() != null && tree.getRightTree().getContent() != null) {
				graph.addNode(idTree.getRightTree().getContent());
				graph.addEdge(new RandomString().nextString(), idTree.getContent(), idTree.getRightTree().getContent());
				iterate(tree.getRightTree(), idTree.getRightTree());
			}

		} else {
			return;
		}
	}
}
