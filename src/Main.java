import my_linked_list_backend.ListNode;
import my_linked_list_backend.Node;
import my_linked_list_backend.Pair;

public class Main {
    public static void main(String[] args) {
//        System.out.println(2^5);
//        System.out.println(2 >> 5);
//        System.out.println(5 >> 2);
//        System.out.println(2 << 5);
//
//        System.out.println("==============");
//
//        System.out.println(101 << 1);
//        System.out.println(101 >> 1);
//        System.out.println(101 >> 2);
//        System.out.println(10 << 2);
//        System.out.println(16 >> 2);
//        printDigitReverse(154);


//        System.out.println(digitReverse(1234567890));
//        System.out.println(convertToBinary(312321));
//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(isPowerOfTwo(16));
//        System.out.println(factorial(4));
//        System.out.println(arithmeticProgrOddNums(99));
//        System.out.println(isPalindrome("anora"));

//        int [] arr1 = {3,4,5};
//        int [] arr2 = {1,2,3,6};
//        Arrays.stream(mergeTwoArray(arr1, arr2)).forEach(System.out::println);
//        System.out.println(Arrays.toString(mergeTwoArray(arr1, arr2)));

//        MyLinkedList<Integer> list = new MyLinkedList<>();

//        list.test(1);
//        list.test(1);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        System.out.println(list);
//        list.print();
//        list.get(2);
//        list.test2(3);

        ListNode listNode = new ListNode();
//        System.out.println("listNode.getFirst() = " + listNode.getFirst());
//        listNode.add(1);
//        listNode.add(2);
//        listNode.add(3);
//        listNode.add(4);
//        listNode.add(5);
//        listNode.add(6);
//        listNode.add(7);
//        listNode.add(8);
//        listNode.add(9);


        //sort and merge
        Node node = new Node(9);
        node.next = new Node(3);
        node.next.next = new Node(0);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(7);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next.next = new Node(0);
//        ListNode list = new ListNode();
////        Node sort = list.sort(node);
//        int [] arr = toArray(node);
////        System.out.println(sort);
//        for (int i : arr) {
//            System.out.println(i);
//        }

        //implement iterator
//        ListNodeIterator listNodeIterator = new ListNodeIterator(node);
//        while (listNodeIterator.hasNext()) {
//                System.out.println(listNodeIterator.current.data);
//                listNodeIterator.next();
//        }

        // serializable
        System.out.println("listNode.writeToFile(node) = " + listNode.serializable(node));
        // deserializable
        System.out.println("listNode.deserializable(\"write_node.txt\") = " + listNode.deserializable("write_node.txt"));
//        listNode.replace(4, 0);
//        listNode.swap(0, 8);
//        li
//        System.out.println("listNode = " + listNode);
//        System.out.println("listNode.getMiddle() = " + listNode.getMiddle());


//        detectCycle(); // detecting has cycle
//        splitLinkedList();


//        listNode.reverse4();
//        System.out.println(listNode);
//        listNode.addFirst(6);
//        listNode.addLast(7);
//        listNode.deleteAtIndex(4);
//        System.out.println("listNode.isEmpty() = " + listNode.isEmpty());
//        System.out.println("listNode.size() = " + listNode.size());
//        listNode.addAtIndex(2, 9);
//        System.out.println(listNode.get(2));
//        System.out.println(listNode.get(5));
//        System.out.println("listNode.getFirst() = " + listNode.getFirst());
//        System.out.println("listNode.getLast() = " + listNode.getLast());


//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(2);
//        list.get(0);
    }

    private static void splitLinkedList() {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        ListNode<Integer> linkedList = new ListNode<>(head);

        Pair<ListNode<Integer>, ListNode<Integer>> result = linkedList.splitLinkedList();
        System.out.println(result);
    }

    private static void detectCycle() {
        Node<Integer> node1 = new Node(1);
        Node<Integer> node2 = new Node(2);
        Node<Integer> node3 = new Node(3);
        Node<Integer> node4 = new Node(4);
        Node<Integer> node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        ListNode listNode = new ListNode();
        System.out.println("listNode.detectCycle(node) = " + listNode.detectCycle(node1));
    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1 + len2];
        int s = 0;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                res[s] = arr1[i];
                i++;
            } else {
                res[s] = arr2[j];
                j++;
            }
            s++;
        }
        while (i < len1) {
            res[s++] = arr1[i++];
        }
        while (j < len2) {
            res[s++] = arr2[j++];
        }
        return res;
    }

    private static boolean isPalindrome(String str) {
//        return str.equals(reverseString(str));
        int low = 0,
                high = str.length() - 1;
        if (str.charAt(low) != str.charAt(high)) return false;
        while (low < high) {
            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int arithmeticProgrOddNums(int num) {
        //s = (a1 +an)/2 * n;
        // an = a1 + (n - 1) *2
        //n = (an - a1)/2 + 1;
        // s = ()
        return (1 + num) / 2 * ((num - 1) / 2 + 1);
    }

    private static int factorial(int num) {
        int p = 1;
        for (int i = 1; i <= num; i++) {
            p *= i;
        }
        return p;
    }

    private static boolean isPowerOfTwo(int num) {
        int bit_count = 0;
        while (num != 0) {
            bit_count += num & 1;
            num = num >> 1;
        }
        return bit_count == 1;
    }

    private static String convertToBinary(int a) {
        StringBuilder res = new StringBuilder();
        while (a != 0) {
            int temp = a % 2;
            res.append(String.valueOf(a));
            a /= 2;
        }
        return reverseString(res.toString());
    }

    private static String reverseString(String str) {
        if (str.isBlank()) return str;
        StringBuilder rev = new StringBuilder();
        while (!str.isBlank()) {
            rev.append(str.substring(str.length() - 1));
            str = str.substring(0, str.length() - 1);
        }
        return rev.toString();
    }

    private static int digitReverse(int a) {
        int b = 0;
        while (a != 0) {
            int temp = a % 10;
            b = b * 10 + temp;
            a /= 10;
        }
        return b;
    }

    private static void printDigitReverse(int a) {
        if (a == 0) return;
        System.out.println(a % 10);
        a /= 10;
        printDigitReverse(a);
    }
}