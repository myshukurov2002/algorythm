package list;

public class Node<E> {
    public E data;
    public Node<E> next;

    public Node(E data) {
        this.data = data;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data + ", \n" +
                "next=" + next +
                '}';
    }
}
