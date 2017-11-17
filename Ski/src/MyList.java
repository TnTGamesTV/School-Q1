import java.lang.reflect.GenericArrayType;
import java.util.Comparator;

/**
 * Created by E6410 on 13.11.2017.
 */
public class MyList<T> {
	private Node<T> first;
	private Node<T> current;
	private Node<T> last;
	private Integer size = 0;

	public void toLast() {
		this.current = last;
	}

	public void toFirst() {
		this.current = first;
	}

	public void toNext() {
		current = current.getNext();
	}

	public void addBeforeCurrent(T content) {
		size++;
		Node<T> result = new Node<>();
		result.setContent(content);
		if (!initCurrentNodeIfNotPresent()) {
			// no elements
			current = result;
			first = result;
			last = result;
		} else {
			Node<T> before = getNodeBefore(current);
			before.setNext(result);
			result.setNext(current);
		}
	}

	public void sort(Comparator<T> comparator, Node<T> param) {
		Node<T> temp = param;
		if (param == null) {
			return;
		}
		if (param == first) {
			return;
		}
		Node<T> next = current.getNext();
		Node<T> prev = getNodeBefore(param);
		while (prev != null) {
			param = prev;
			if (comparator.compare(param.getContent(), prev.getContent()) == -1) {
				break;
			}
			prev = getNodeBefore(prev);
		}
		if(prev == null) {
			param = prev;
		}
		insert(param,temp);
		sort(comparator,next);
	}

	public void insert(Node<T> prev, Node<T> toAdd) {
		if (prev == null) {
			toAdd.setNext(first);
			setFirst(toAdd);
			return;
		}
		toAdd.setNext(prev.getNext());
		prev.setNext(toAdd);
	}

	public Node<T> getNodeBefore(Node<T> node) {
		if (first == null || node == first)
			return null;
		Node<T> temp = first;
		while (temp != null && temp != node && temp.getNext() != node) {
			temp = temp.getNext();
		}
		return temp;
	}

	public T get(Integer counter) {
		if (counter > size)
			return null;
		Node<T> temp = first;
		for (int i = 0; i < counter; i++) {
			temp = temp.getNext();
		}
		return temp != null ? temp.getContent() : null;
	}

	public void addAfterCurrent(T content) {
		size++;
		Node<T> node = new Node<>();
		node.setContent(content);
		if (current != null && current.getNext() != null) {
			Node<T> temp = current.getNext();
			node.setNext(temp);
		}
		if (!initCurrentNodeIfNotPresent()) {
			first = node;
		} else {
			current.setNext(node);
		}
		setCurrent(node);
	}

	private boolean initCurrentNodeIfNotPresent() {
		boolean result = current != null;
		if (first == null) {
			Node<T> temp = new Node<>();
			first = temp;
			last = temp;
			current = temp;
		}
		return result;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public Node<T> getCurrent() {
		return current;
	}

	public void setCurrent(Node<T> current) {
		this.current = current;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

}
