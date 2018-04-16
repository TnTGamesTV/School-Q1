package graphical;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

import com.github.tntgamestv.school.BinaryTree;

/**
 * @author Finn Tegeler
 */
public class GraphicalTreeWrapper<T> {

	private static String				STYLESHEET	= "node { fill-color: black; text-size: 20px; }"
			+ "node.marked { fill-color: red; }";

	private Graph						graph;
	private BinaryTree<T>				tree;
	private BinaryTree<String>			idTree;

	private IGraphicalTreeNodeNamer<T>	namer;

	public GraphicalTreeWrapper(BinaryTree<T> tree) {
		this.graph = new SingleGraph("Tree");
		this.tree = tree;
		this.idTree = new BinaryTree<>();

		this.idTree.setContent("");
		this.prepareIdTree(this.tree, idTree);
	}

	public GraphicalTreeWrapper(BinaryTree<T> tree, IGraphicalTreeNodeNamer<T> namer) {
		this(tree);

		this.namer = namer;
	}

	private void prepareIdTree(BinaryTree<T> tree, BinaryTree<String> idTree) {
		if (!tree.isEmpty()) {
			if (tree.getLeftTree() != null && tree.getLeftTree().getContent() != null) {
				idTree.setLeftTree(new BinaryTree<String>(""));
				prepareIdTree(tree.getLeftTree(), idTree.getLeftTree());
			}

			// Create new node
			idTree.setContent(new RandomString().nextString());

			if (tree.getRightTree() != null && tree.getRightTree().getContent() != null) {
				idTree.setRightTree(new BinaryTree<String>(""));
				prepareIdTree(tree.getRightTree(), idTree.getRightTree());
			}

		}
	}

	public void display() {
		graph.setStrict(true);

		graph.setAttribute("ui.stylesheet", STYLESHEET);

		graph.addNode(idTree.getContent());
		graph.getNode(idTree.getContent()).addAttribute("ui.class", "marked");

		iterate(tree, idTree);

		Viewer viewer = graph.display(true);
		HierarchicalLayout hl = new HierarchicalLayout();
		hl.compute();
		viewer.enableAutoLayout(hl);
	}

	private void addEdge(String from, String to, boolean left) {
		String id = new RandomString().nextString();

		graph.addEdge(id, from, to);
		graph.getEdge(id).setAttribute("ui.label", left ? "Left" : "Right");
	}

	private void iterate(BinaryTree<T> tree, BinaryTree<String> idTree) {
		if (!tree.isEmpty()) {
			if (tree.getLeftTree() != null && tree.getLeftTree().getContent() != null) {
				graph.addNode(idTree.getLeftTree().getContent());
				this.addEdge(idTree.getContent(), idTree.getLeftTree().getContent(), true);
				iterate(tree.getLeftTree(), idTree.getLeftTree());
			}

			// Create new node
			graph.getNode(idTree.getContent()).setAttribute("ui.label",
					namer == null ? tree.getContent().toString() : namer.getNodeName(tree));

			if (tree.getRightTree() != null && tree.getRightTree().getContent() != null) {
				graph.addNode(idTree.getRightTree().getContent());
				this.addEdge(idTree.getContent(), idTree.getRightTree().getContent(), false);

				iterate(tree.getRightTree(), idTree.getRightTree());
			}

		} else {
			return;
		}
	}
}
