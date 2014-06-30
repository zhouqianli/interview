package cict.ch02;

import java.lang.reflect.Array;

/**
 * A singly linked list
 */
public class LinkedList<T extends Comparable<T>> {
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

    public LinkedList append(T in) {
        if (tail == null) {
            tail = new Node(in);
            head = tail;
        } else {
            tail.next = new Node(in);
            tail = tail.next;
        }
        ++length;
        return this;
    }

    public T[] toArray() {
        if (head == null) return null;
        Node p = head;
        @SuppressWarnings("unchecked")
        final T[] r = (T[]) Array.newInstance(head.data.getClass(), length);
        for (int i = 0; i < length; i++) {
            r[i] = p.data;
            p = p.next;
        }
        return r;
    }

    public LinkedList delete(T in) {
        Node p = head;
        if (p == null) return this;
        if (p.data.equals(in))
            head = head.next;

        while (p.next != null) {
            if (p.next.data.equals(in)) {
                p.next = p.next.next;
                --length;
                break;
            }
        }
        return this;
    }

    /**
     * ctci question 2.4
     * Write code to partition a liked list around a value x, such that all nodes
     * less than x come before all nodes greater than or equal to x.
     * <p>
     *
     * @param x the value for partition
     * @return partitioned list.  Return original list if it is null, empty or all bigger or less the x
     */
    public LinkedList partition(T x) {
        Node lesser = head;
        Node bigger = head;
        Node p = head;

        while (p != null) {
            Node next = p.next;
            if (p.data.compareTo(x) < 0) {
                p.next = lesser;
                lesser = p;
            } else {
                bigger.next = p;
                bigger = p;
            }
            p = next;
        }
        bigger.next = null;
        head = lesser;  // reset header & tailer is very important
        tail = bigger;
        return this;
    }
}
