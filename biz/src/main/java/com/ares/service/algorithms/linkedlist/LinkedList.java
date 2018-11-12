package com.ares.service.algorithms.linkedlist;

/**
 * 链表
 *
 * @author 0xZzzz
 */
public class LinkedList {

    private Node head;

    private Node tail;

    private long length;

    public void add(String data) {
        length++;
        // first
        if (head == null) {
            head = new Node(data);
            tail = head;
            return;
        }
        tail.next = new Node(data);
        tail = tail.next;
    }

    public Node head() {
        return head;
    }

    public long length() {
        return length;
    }

    @Override
    public String toString() {
        return head.print();
    }

    public class Node {

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

        public String print() {
            return next == null ? data : data + " --> " + next.print();
        }
    }

}
