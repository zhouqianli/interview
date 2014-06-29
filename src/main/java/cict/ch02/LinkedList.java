package cict.ch02;

/**
 * A singly linked list
 */
public class LinkedList<T> {
    public class Node {
        private T data;
        private Node next = null;

        public Node(T in) {
            if (in != null)
                data = in;
        }
    }

    private Node tail = null;
    private Node head = null;
    private int length = 0;

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public LinkedList append(T in) {
        if (tail == null) {
            tail = new Node(in);
            head = tail;
            tail.next = null;
        } else
            tail.next = new Node(in);
        return this;
    }

    public LinkedList delete(T in) {
        Node p = head;
        if (p.data.equals(in))
            head = head.next;

        while (p != null && p.next != null) {
            if (p.next.data.equals(in)) {
                p.next = p.next.next;
                break;
            }
        }
        return this;
    }
}
