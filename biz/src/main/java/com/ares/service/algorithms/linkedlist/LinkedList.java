package com.ares.service.algorithms.linkedlist;

/**
 * 链表
 *
 * @author 0xZzzz
 */
public class LinkedList {

    private Node head;

    private Node tail;

    public void add(String data) {
        add(new Node(data));
    }

    public void add(Node node) {
        // first
        if (head == null) {
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }

    public Node head() {
        return head;
    }

    public boolean isCyclic() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 反转，遍历将head指针移向最后一个节点，将所有节点的next节点指向前一个节点，即可完成反转
     */
    public void reverse() {
        Node pointer = head;
        Node previous = null, current;
        while (pointer != null) {
            current = pointer;
            pointer = pointer.next;
            // 反转
            current.next = previous;
            previous = current;
            head = current;
        }
    }

    /**
     * 链表长度
     */
    public int length() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next();
        }
        return count;
    }

    /**
     * 链表长度，递归
     */
    public int lengthRecursively() {
        return lengthRecursively(head);
    }

    private int lengthRecursively(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + lengthRecursively(current.next());
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }
        Node current = head;
        StringBuilder stringBuilder = new StringBuilder(head.data);
        while (current.next != null) {
            current = current.next;
            stringBuilder.append(" --> ").append(current.data);
        }
        return stringBuilder.toString();
    }

    public static class Node {

        private String data;

        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public String data() {
            return data;
        }

        @Override
        public String toString() {
            return data;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Node && data.equals(((Node)obj).data);
        }
    }

}
