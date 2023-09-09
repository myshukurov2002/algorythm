package my_linked_list_backend;

import java.io.Serializable;

public class Node<E> implements Serializable {
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
