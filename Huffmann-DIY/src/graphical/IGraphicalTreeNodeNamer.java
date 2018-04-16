package graphical;

import com.github.tntgamestv.school.BinaryTree;

/**
 * @author Finn Tegeler
 */
public interface IGraphicalTreeNodeNamer<T> {

	String getNodeName(BinaryTree<T> b);
}
