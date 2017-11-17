/**
 * Created by E6410 on 13.11.2017.
 */
public class Node<T> {
    private T content;
    private Node<T> next;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
