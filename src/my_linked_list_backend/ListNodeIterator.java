package my_linked_list_backend;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ListNodeIterator implements Iterator<Integer> {
    public Node<Integer> current;
    public ListNodeIterator(Node head) {
        this.current = head;
    }
    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int value = current.data;
        current = current.next;
        return value;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        Iterator.super.forEachRemaining(action);
    }
}
