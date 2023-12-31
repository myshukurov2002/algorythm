package my_linked_list_backend;

import java.io.*;

public class ListNode<E> {
    private Node<E> head;
    private Node<E> last;
    private int size;

    public ListNode() {
        head = null;
        size = 0;
    }

    public ListNode(E data) {
        head.data = data;
        size = 0;
    }

    public ListNode(Node<E> head) {
        this.head = head;
        size = 0;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void addAtIndex(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS EXCEPTION !!!");
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size - 1) {
            addLast(data);
        }
        Node<E> newNode = new Node<>(data);
        Node<E> tempNode = head;

        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("NOT FOUND ITEM AT INDEX !!!");
        }
        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ITEM NOT FOUND IN THAT INDEX!!!");
        }
        Node<E> temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public E getFirst() {
        Node<E> temp = head;
        if (temp == null) {
            throw new IndexOutOfBoundsException("NOTHING IS AVAILABLE!!!");
        }
        return temp.data;
    }

    public E getLast() {
        Node<E> temp = last;
        if (temp == null) {
            throw new IndexOutOfBoundsException("NOTHING IS AVAILABLE!!!");
        }
        return temp.data;
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void reverse2() {
        Node<E> current = head;
        Node<E> prev = null;
        Node<E> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void reverse3() {
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void reverse4() {
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Override
    public String toString() {
        return "ListNode{" + head + '}';
    }

    public Node<E> detectCycle(Node<E> node) {
        if (node == null || node.next == null) {
            return null;
        }
        boolean hasCycle = false;
        Node<E> fast = node;
        Node<E> slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
//                hasCycle = true;
//                break;
                return slow;
            }
        }
        return null;
//        if (!hasCycle) {
//            return null;
//        }
//
//        slow = head;
//        while (slow != fast) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//        return slow;
    }

    public Pair<ListNode<E>, ListNode<E>> splitLinkedList() {
        Node<E> slow = head;
        Node<E> fast = head;
        Node<E> prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return new Pair<>(this, new ListNode<>(slow));
    }

    public Node<Integer> sort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<E> middle = findMiddle(node);
        Node<E> left =  node;
        Node<E> right = middle.next;
        middle.next = null;
        Node<Integer> sortedLeft = sort(left);
        Node<Integer> sortedRight = sort(right);
        return merge(sortedLeft, sortedRight);

//        return merge(sortedLeft, sortedRight);
    }

    private Node<Integer> merge(Node l, Node r) {

        Node<Integer> dummy = new Node(-1);
        Node<Integer> current = dummy;
        Node<Integer> left = (Node<Integer>) l;
        Node<Integer> right = (Node<Integer>) r;

        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }
        return dummy.next;
    }

    public String serializable(Node node) {
        try(FileOutputStream file = new FileOutputStream("write_node.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);) {

            Node current = node;

            out.writeObject(node);
            return "SUCCESS";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void replace(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ITEM NOT FOUND AT THiS INDEX !!!");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
        //0 1 2 3 4 5
        //1 5 3 7 4 2
        //    ^
        //    9
    }

    public void swap(int index_A, int index_B) {
        if (index_A < 0 || index_A >= size ||
                index_B < 0 || index_B >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index_A == index_B) {
            return;
        }
        Node<E> node_A = head;
        Node<E> node_B = head;
        if (index_A < index_B) {
            for (int i = 0; i < index_A; i++) {
                node_A = node_A.next;
            }
            for (int i = 0; i < index_B; i++) {
                node_B = node_B.next;
            }
            E tempData = node_A.data;
            node_A.data = node_B.data;
            node_B.data = tempData;
        } else {
            swap(index_B, index_A);
        }
    }

    public static int[] toArray(Node head) {
        Node node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        node = head;
        int [] arr = new int[size];
        int i = 0;
        while (node != null) {
            arr[i] = (int) node.data;
            node = node.next;
            i++;
        }
        return arr;
    }

    public Node deserializable(String fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            Node node = (Node) in.readObject();

            return node;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
